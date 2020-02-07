package leetcode.p100

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * <pre>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * </pre>
 */
object P002AddTwoNumberes {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var a = l1
    var b = l2
    var carry = 0
    var r: ListNode = ListNode(-1)
    val dummy = r
    while (a != null || b != null) {
      var num = carry
      if (b != null) {
        num += b.x
        b = b.next
      }
      if (a != null) {
        num += a.x
        a = a.next
      }

      if (num > 9) {
        carry = 1
        num = num % 10
      } else {
        carry = 0
      }
      r.next = ListNode(num)
      r = r.next
    }
    if (carry == 1) {
      r.next = ListNode(1)
    }

    dummy.next
  }
}

case class ListNode(var x: Int = 0, var next: ListNode = null)
