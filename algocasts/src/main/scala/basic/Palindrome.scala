package basic

import util.StringUtils

/**
 * 回文字符串判断
 */
object Palindrome {
  import util.Utils._

  private def isEqualIgnoreCase(a: Char, b: Char): Boolean = {
    val x = if (isBetween(a, 'A', 'Z')) a + 32 else a
    val y = if (isBetween(a, 'A', 'Z')) b + 32 else b
    x == y
  }

  // Time: O(n), Space: O(1)
  def isPalindrome(s: String): Boolean = {
    if (StringUtils.isEmpty(s)) true
    else {
      var i = 0
      var j = s.length - 1
      while (i < j) {
        while (i < j && !isAlphanumeric(s.charAt(i))) i += 1
        while (i < j && !isAlphanumeric(s.charAt(j))) j -= 1
        if (i < j && !isEqualIgnoreCase(s.charAt(i), s.charAt(j))) return false

        i += 1
        j -= 1
      }

      true
    }
  }

  def main(args: Array[String]): Unit = {
    println(isPalindrome("abcdefgfedcba"))
    println(isPalindrome("abcdefggfedcba"))
    println(isPalindrome("abcdefggedcba"))
    println(isPalindrome("abcdggfedcba"))
  }
}
