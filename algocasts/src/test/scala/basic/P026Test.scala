package basic

import org.scalatest.{ FunSuite, Matchers }

class P026Test extends FunSuite with Matchers {
  import P026._

  test("testLongestPalindrome") {
    longestPalindrome("abcbab") should ===("abcba")
    longestPalindrome("abcbcbd") should ===("bcbcb")
  }
}
