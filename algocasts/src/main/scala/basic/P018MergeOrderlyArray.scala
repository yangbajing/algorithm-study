package basic

import series.ListNode

import scala.collection.mutable
import scala.reflect.ClassTag

/**
 * P18. 合并两个有序链表
 * https://algocasts.io/series/algo-problems-1-50/episodes/17WMoGjw
 * 这个题目说的是，给你两个递增排序的链表，你要把它们合成一个链表，并且保持递增排序。另外要求，新链表上的节点使用的就是旧的两个链表上的节点，不能创建新节点。
 * <pre>
 * 比如说，给你的两个链表 L1 和 L2，分别是：
 *
 * L1: 1 -> 3
 *
 * L2: 2 -> 4 -> 6
 *
 * 合并后的链表就是：
 *
 * 1 -> 2 -> 3 -> 4 -> 6
 * </pre>
 */
object P018MergeOrderlyArray {
  private def initArray[T](dest: Array[T], src: scala.collection.IndexedSeq[T]): Unit = {
    var i = 0
    while (i < src.length) {
      dest(i) = src(i)
      i += 1
    }
  }

  def mergeOrderly[T: ClassTag](l1: scala.collection.IndexedSeq[T], l2: scala.collection.IndexedSeq[T])(
      implicit ev1: T => Ordered[T]): mutable.IndexedSeq[T] = {
    val xLen = l1.length
    val yLen = l2.length
    val arr = Array.ofDim[T](xLen + yLen)
    initArray(arr, l1)
    var i = xLen - 1
    var j = yLen - 1
    var k = arr.length - 1
    while (i >= 0 && j >= 0) {
      if (l2(j) > l1(i)) {
        arr(k) = l2(j)
        j -= 1
      } else {
        arr(k) = l1(i)
        i -= 1
      }
      k -= 1
    }

    while (j >= 0) {
      arr(k) = l2(j)
      k -= 1
      j -= 1
    }

    arr
  }

  def mergeList[T](x: ListNode[T], y: ListNode[T])(implicit ev1: Ordering[T]): ListNode[T] = {
    import ev1._
    val dummy = ListNode(null.asInstanceOf[T])
    var node = dummy
    var a = x
    var b = y
    while (a != null && b != null) {
      if (a.value < b.value) {
        node.next = a
        a = a.next
      } else {
        node.next = b
        b = b.next
      }
      node = node.next
    }

    if (a != null) node.next = a
    if (b != null) node.next = b

    dummy.next
  }
}
