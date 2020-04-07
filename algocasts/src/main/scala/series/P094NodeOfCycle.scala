package series

import scala.collection.mutable

/**
 * P94. 单链表中圆环的开始节点
 * 这个题目说的是，给你一个单链表，你要返回这个链表中，圆环的开始节点。如果单链表无环，就返回空指针。
 * <pre>
 * 比如说，给你的单链表是：
 *
 * 1 -> 2 -> 4 -> 8 -> 2
 * // 最后的 2 和前面的 2 是同一个节点
 *
 * 这个链表中存在环，并且环的开始节点是 2，于是你要返回节点 2。
 * </pre>
 */
object P094NodeOfCycle {
  def startNodeOfCycleHashSet[T](head: ListNode[T]): ListNode[T] = {
    val set = mutable.Set[ListNode[T]]()
    var p = head
    while (p != null) {
      if (set.contains(p)) return p
      set += p
      p = p.next
    }
    null
  }

  // Time: O(n), Space: O(1)
  def startNodeOfCycleTwoPointer[T](head: ListNode[T]): ListNode[T] = {
    var slow = head
    var fast = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
      if (slow eq fast) {
        var p = head
        while (p != slow) { p = p.next; slow = slow.next }
        return slow
      }
    }
    null
  }
}
