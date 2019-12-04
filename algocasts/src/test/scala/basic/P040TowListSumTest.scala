package basic

import org.scalatest.{ FunSuite, Matchers }

class P040TowListSumTest extends FunSuite with Matchers {
  import P040TowListSum._
  test("testTwoListNumbersSum") {
    twoListNumbersSum(List(1, 2, 3), Vector(6, 7, 8, 9)) should be(Array(7, 9, 1, 0, 1))
  }
}
