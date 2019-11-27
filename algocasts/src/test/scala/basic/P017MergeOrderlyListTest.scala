package basic

import org.scalatest.{ FunSuite, Matchers }

class P017MergeOrderlyListTest extends FunSuite with Matchers {
  import P017MergeOrderlyList._
  test("mergeOrderly") {
    val l1 = ListNode(1, ListNode(3, ListNode(7, ListNode(8, ListNode(18)))))
    val l2 = ListNode(0, ListNode(4, ListNode(5, ListNode(6, ListNode(12)))))
    val result = mergeOrderly(l1, l2)
    println(result)
  }
}
