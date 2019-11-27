package basic

import org.scalatest.{ FunSuite, Matchers }

class P025LengthOfLongestSubstringTest extends FunSuite with Matchers {
  import P025LengthOfLongestSubstring._

  test("testLengthOfLongestSubstring") {
    lengthOfLongestSubstring("abcabcbb") should ===(3)
    lengthOfLongestSubstring("abcebcbb") should ===(4)
    lengthOfLongestSubstring("abcdefg") should ===(7)
  }
}
