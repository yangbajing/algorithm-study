package basic

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P012PalindromicTest extends AnyWordSpec with Matchers {
  import P012Palindromic._
  "Palindromic" should {
    "dp(abc)" in { countPalindromicSubstringsDP("abc") shouldBe 3 }

    "dp(abad)" in { countPalindromicSubstringsDP("abad") shouldBe 5 }

    "dp(abccba)" in { countPalindromicSubstringsDP("abccba") shouldBe 9 }

    "expend(abc)" in { countPalindromicSubstringsExpand("abc") shouldBe 3 }

    "expend(abad)" in { countPalindromicSubstringsExpand("abad") shouldBe 5 }

    "expend(abccba)" in { countPalindromicSubstringsExpand("abccba") shouldBe 9 }
  }
}
