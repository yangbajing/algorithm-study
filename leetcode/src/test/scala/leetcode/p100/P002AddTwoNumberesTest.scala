package leetcode.p100

import org.scalatest.funsuite.AnyFunSuite
import P002AddTwoNumberes._
import org.scalatest.matchers.should.Matchers

class P002AddTwoNumberesTest extends AnyFunSuite with Matchers {
  test("addTwoNumbers") {
    addTwoNumbers(build(2, 4, 3), build(5, 6, 4)) shouldBe build(7, 0, 8)
    addTwoNumbers(build(5, 1, 7), build(8, 9, 3)) shouldBe build(3, 1, 1, 1)
    addTwoNumbers(build(1, 8), build(0)) shouldBe build(1, 8)
    addTwoNumbers(build(9, 8), build(1)) shouldBe build(0, 9)
    addTwoNumbers(build(9, 9), build(1)) shouldBe build(0, 0, 1)
  }

  test("build") {
    build(2, 4, 3) shouldBe ListNode(2, ListNode(4, ListNode(3)))
    build(5, 6, 4) shouldBe ListNode(5, ListNode(6, ListNode(4)))
    build(7, 0, 8) shouldBe ListNode(7, ListNode(0, ListNode(8)))
  }

  private def build(nums: Int*): ListNode = {
    val dummy = ListNode(-1, null)
    var r = dummy
    nums.foreach { num =>
      r.next = ListNode(num)
      r = r.next
    }
    dummy.next
  }
}
