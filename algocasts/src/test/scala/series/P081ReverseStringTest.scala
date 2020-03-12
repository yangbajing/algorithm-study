package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P081ReverseStringTest extends AnyWordSpec with Matchers {
  import P081ReverseString._
  "Reverse string" should {
    "abcde reverse to edcba" in {
      reverseString("abcde") shouldBe "edcba"
    }
    "abcd reverse to dcba" in {
      reverseString("abcd") shouldBe "dcba"
    }
    "null reverse to null" in {
      reverseString(null) shouldBe null
    }
  }
}
