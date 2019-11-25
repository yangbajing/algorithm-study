package basic

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
