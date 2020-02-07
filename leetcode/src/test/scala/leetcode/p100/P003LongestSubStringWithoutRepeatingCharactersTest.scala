package leetcode.p100

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import P003LongestSubStringWithoutRepeatingCharacters._

class P003LongestSubStringWithoutRepeatingCharactersTest extends AnyFunSuite with Matchers {
  test("lengthOfLongestSubstring") {
    lengthOfLongestSubstring("abcabcbe") shouldBe 3
    lengthOfLongestSubstring("abcabcaeefgh") shouldBe 4
    lengthOfLongestSubstring("abcabcaeefghih") shouldBe 5
    lengthOfLongestSubstring("bbbbb") shouldBe 1
    lengthOfLongestSubstring("pwwkew") shouldBe 3
    lengthOfLongestSubstring("aab") shouldBe 2
    lengthOfLongestSubstring("dvdf") shouldBe 3
  }
}
