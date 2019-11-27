package basic

import java.util.Objects

import scala.collection.mutable

/**
 * P27. 判断单链表是否有环
 * https://algocasts.io/series/algo-problems-1-50/episodes/q2m52Gzn
 * 这个题目说的是，给你一个单链表，你要判断它是否会形成环，也就是链表的最后一个节点指向了前面一个已经存在的节点。
 */
object P027IsCycleList {
  class ListNode[T](val value: T, var next: ListNode[T])
  object ListNode {
    def apply[T](value: T, next: ListNode[T] = null): ListNode[T] = new ListNode(value, next)
  }

  // Time: O(n), Space: O(n)
  def isCycleWithHashSet[T](node: ListNode[T]): Boolean = {
    require(Objects.nonNull(node))
    val set = mutable.Set.empty[ListNode[T]]
    var p = node
    var b = false
    while (!b && p != null) {
      b = set(p)
      if (!b) {
        set.add(p)
      }
      p = p.next
    }
    b
  }

  // Time: O(n), Space: O(1)
  def isCycleWithTowPointer[T](node: ListNode[T]): Boolean = {
    require(Objects.nonNull(node))
    var fast = node
    var slow = node
    var b = false
    while (!b && fast != null && fast.next != null) {
      fast = fast.next.next
      slow = slow.next
      b = fast == slow // fast and slow same is null?
      println(s"b:$b, fast:$fast, slow:$slow")
    }
    b
  }
}
