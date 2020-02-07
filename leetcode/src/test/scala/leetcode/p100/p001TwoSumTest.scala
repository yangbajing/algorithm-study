package leetcode.p100

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import P001TwoSum._

class p001TwoSumTest extends AnyFunSuite with Matchers {
  test("twoSum") {
    twoSum(Array(2, 7, 11, 15), 9) shouldBe Array(0, 1)
    twoSum(Array(2, 7, 11, 15), 17) shouldBe Array(0, 3)
    twoSum(Array(2, 7, 11, 15), 26) shouldBe Array(2, 3)
    twoSum(Array(2, 7, 11, 15), 18) shouldBe Array(1, 2)
    twoSum(Array(2, 7, 11, 15), 13) shouldBe Array(0, 2)
  }
}
