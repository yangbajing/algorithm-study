package leetcode.p100

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P007ReverseIntegerTest extends AnyWordSpec with Matchers {
  import P007ReverseInteger._
  "P007ReverseInteger" should {
    "reverse(123) be 321" in { reverse(123) shouldBe 321 }
    "reverse(-123) be -321" in { reverse(123) shouldBe 321 }
    "reverse(120) be 21" in { reverse(120) shouldBe 21 }
    "reverse(1534236469) be 0" in { reverse(1534236469) shouldBe 0 }
    "reverse(-2147483412) be -2143847412" in { reverse(-2147483412) shouldBe -2143847412 }
  }
}
