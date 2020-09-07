package leetcode.p100

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

/**
 * @author yangbajing <a href="mailto://yang.xunjing@qq.com">羊八井</a>
 * @date 2020-09-07 20:58
 */
class P026RemoveDuplicatesTest extends AnyFunSuite with Matchers {
  import P026RemoveDuplicates._
  test("testRemoveDuplicates(Array(1, 1, 2))") {
    val arr = Array(1, 1, 2)
    removeDuplicates(arr) shouldBe 2
    arr shouldBe Array(1, 2, 2)
  }
  test("testRemoveDuplicates(Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4))") {
    val arr = Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    removeDuplicates(arr) shouldBe 5
    arr shouldBe Array(0, 1, 2, 3, 4, 2, 2, 3, 3, 4)
  }
}
