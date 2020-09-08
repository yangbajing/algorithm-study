package leetcode.p100

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * @author yangbajing <a href="mailto://yang.xunjing@qq.com">羊八井</a>
 * @since 2020-09-08 20:12
 */
class P011MaxWaterTest extends AnyWordSpec with Matchers {
  import P011MaxWater._

  "P011MaxWaterTest" should {
    "maxArea(1, 8, 6, 2, 5, 4, 8, 3, 7)" in {
      maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)) shouldBe 49
    }
    "maxArea(1, 1)" in {
      maxArea(Array(1, 1)) shouldBe 1
    }
  }
}
