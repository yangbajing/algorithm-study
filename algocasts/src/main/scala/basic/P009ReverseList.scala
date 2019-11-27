package basic

/**
 * P9. 反转单链表
 * 这个题目说的是，给你一个单链表，你需要反转它，然后返回。
 * <pre>
 * 比如说给你的单链表是：
 *
 * 1 -> 2 -> 3 -> 4 -> 5 -> null
 *
 * 你要返回的反转后的链表是：
 *
 * 5 -> 4 -> 3 -> 2 -> 1 -> null
 * </pre>
 */
object P009ReverseList {
  case class ListNode(value: Int, var next: Option[ListNode])

  // Time: O(n), Space: O(1)
  def reverseList(head: ListNode): Option[ListNode] = {
    var cur = Option(head)
    var pre = Option.empty[ListNode]
    while (cur.nonEmpty) {
      val next = cur.get.next
      cur.get.next = pre
      pre = cur
      cur = next
    }
    pre
  }

  def main(args: Array[String]): Unit = {
    val list = ListNode(1, Some(ListNode(2, Some(ListNode(3, Some(ListNode(4, Some(ListNode(5, None)))))))))

    val reverse = reverseList(list)
    println(reverse)
  }
}
