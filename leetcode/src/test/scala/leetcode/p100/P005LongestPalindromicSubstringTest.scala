package leetcode.p100

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import P005LongestPalindromicSubstring._

class P005LongestPalindromicSubstringTest extends AnyFunSuite with Matchers {
  test("longestPalindrome") {
    /**
     * b
     * a
     * bab
     * - baba
     * b
     * aba
     * b
     * baa
     *
     */
    longestPalindrome("babad") should (be("bab") or be("aba"))
//    longestPalindrome("cbbd") shouldBe "bb"
//    longestPalindrome("cbb") shouldBe "bb"
//    longestPalindrome("ca") should (be("a") or be("c"))
//    longestPalindrome("b") shouldBe "b"
  }
}
