package leetcode.p100

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import P004MedianSortedArrays._

class P004MedianSortedArraysTest extends AnyFunSuite with Matchers {
  test("findMedianSortedArrays") {
//    findMedianSortedArrays(Array(1, 3), Array(2)) shouldBe 2.0
    findMedianSortedArrays(Array(3, 4), Array(1, 2)) shouldBe 2.5
    // 1, 2, 3, 5, 7, 9
//    findMedianSortedArrays(Array(1, 5, 9), Array(2, 3, 7)) shouldBe 4
//    findMedianSortedArrays(Array(1, 7, 9), Array()) shouldBe 7
//    findMedianSortedArrays(Array(), Array(1, 8)) shouldBe 4.5
//    findMedianSortedArrays(Array(), Array(8)) shouldBe 8
  }
}
