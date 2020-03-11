package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P070LengthOfLongestPalindromeTest extends AnyWordSpec with Matchers {
  import P070LengthOfLongestPalindrome._
  "LengthOfLongestPalindrome" should {
    "lengthOfLongestPalindrome(aaabccdd)" in { lengthOfLongestPalindrome("aaabccdd") shouldBe 7 }
    "lengthOfLongestPalindrome(aaaccdd)" in { lengthOfLongestPalindrome("aaaccdd") shouldBe 7 }
    "lengthOfLongestPalindrome(aaccdd)" in { lengthOfLongestPalindrome("aaccdd") shouldBe 6 }
  }
}
