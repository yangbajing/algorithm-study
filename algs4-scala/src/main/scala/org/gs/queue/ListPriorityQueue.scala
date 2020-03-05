package org.gs.queue

import scala.annotation.tailrec
import scala.reflect.ClassTag

// O(n)
abstract class ListPriorityQueue[T](implicit ord: Ordering[T]) extends Iterable[T] {
  import ListPriorityQueue._

  private val dummy: Node[T] = Node(null.asInstanceOf[T])

  private var n = 0

  protected def cmp(nv: T, v: T): Boolean

  def enqueue(v: T): Unit = {
    @tailrec
    def loop(root: Node[T]): Unit = root.next match {
      case null => root.next = Node(v)
      case node if cmp(node.value, v) =>
        if (node.next == null) node.next = Node(v) else loop(node.next)
      case node => root.next = Node(v, node)
    }

    loop(dummy)
    n += 1
  }

  def dequeue: Option[T] = {
    if (isEmpty) {
      None
    } else {
      val v = head
      dummy.next = dummy.next.next
      n -= 1
      Some(v)
    }
  }

  override def headOption: Option[T] = Option(dummy.next).map(_.value)

  override def head: T = dummy.next.value

  override def isEmpty: Boolean = n == 0

  override def size: Int = n

  override def iterator: Iterator[T] = {
    new Iterator[T] {
      private var node = dummy.next
      override def hasNext: Boolean = node ne null

      override def next(): T = {
        val value = node.value
        node = node.next
        value
      }
    }
  }
}

object ListPriorityQueue {
  case class Node[T](var value: T, var next: Node[T] = null)
}

class ListMaxPQ[T: ClassTag](elems: T*)(implicit ord: Ordering[T]) extends ListPriorityQueue[T] {
  elems.foreach(enqueue)
  override protected def cmp(nv: T, v: T): Boolean = ord.gt(nv, v)
}

class ListMinPQ[T: ClassTag](elems: T*)(implicit ord: Ordering[T]) extends ListPriorityQueue[T] {
  elems.foreach(enqueue)
  override protected def cmp(nv: T, v: T): Boolean = ord.lt(nv, v)
}
