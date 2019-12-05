package series

import org.scalatest.{ FunSuite, Matchers }

class P052RemoveNTHFromEndTest extends FunSuite with Matchers {
  import P052RemoveNTHFromEnd._
  test("testRemoveNthFromEnd") {
    removeNthFromEnd(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))), 3) should be(
      ListNode(1, ListNode(2, ListNode(4, ListNode(5)))))
  }
}
