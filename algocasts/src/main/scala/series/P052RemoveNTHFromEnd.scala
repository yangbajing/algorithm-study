package series

/**
 * P52. 移除单链表倒数第 n 个节点
 * https://algocasts.io/series/algo-problems-51-100/episodes/eAGQQlG4
 * 这个题目说的是，给你一个单链表和数字 n，你要移除单链表倒数第 n 个节点，然后返回单链表。
 * <pre>
 * 比如说，给你的单链表是：
 *
 * 1 -> 2 -> 4 -> 8
 *
 * 给你的数字 n 是 3，单链表中倒数第 3 个节点是 2，移除 2 以后的单链表是：
 *
 * 1 -> 4 -> 8
 * </pre>
 */
object P052RemoveNTHFromEnd {
  def removeNthFromEnd[T](list: ListNode[T], n: Int): ListNode[T] = {
    val dummy = ListNode[T](null.asInstanceOf[T])
    dummy.next = list
    var p = dummy
    var q = dummy
    var i = n
    while (i > 0 && q.next != null) {
      i -= 1
      q = q.next
    }
    if (i != 0) return dummy.next

    while (q.next != null) {
      p = p.next
      q = q.next
    }
    p.next = p.next.next
    dummy.next
  }
}
