package basic

import util.StringUtils

object P012Palindromic {
  // Time: O(n%2), Space: O(n%2)
  def countPalindromicSubstringsDP(s: String): Int = {
    if (StringUtils.isEmpty(s)) return 0

    val n = s.length
    val d = Array.ofDim[Boolean](n, n)
    var count = 0

    var i = n - 1
    while (i >= 0) {
      var j = i
      while (j < n) {
        d(i)(j) =
          if (i == j) true
          else if (i + 1 == j) s.charAt(i) == s.charAt(j)
          else s.charAt(i) == s.charAt(j) && d(i + 1)(j - 1)

        if (d(i)(j)) {
          count += 1
        }

        j += 1
      }
      i -= 1
    }

    count
  }

  private def expand(s: String, l: Int, r: Int): Int = {
    var count = 0
    var left = l
    var right = r
    while (left >= 0 && right < s.length && s.charAt(left) == s.charAt(right)) {
      count += 1
      println(s"$s, $left:${s.charAt(left)} $right:${s.charAt(right)}, $count")
      left -= 1
      right += 1
    }
    count
  }

  // Time: O(n^2), Space: O(1)
  def countPalindromicSubstringsExpand(s: String): Int = {
    if (StringUtils.isEmpty(s)) return 0

    var count = 0
    var i = 0
    while (i < s.length) {
      count += expand(s, i, i)
      count += expand(s, i, i + 1)
      i += 1
    }

    count
  }

  def main(args: Array[String]): Unit = {
    println(countPalindromicSubstringsDP("abc"))
    println(countPalindromicSubstringsDP("abad"))
    println(countPalindromicSubstringsDP("abc"))
    println(countPalindromicSubstringsDP("abccba"))
    println(Vector.fill(80)('-').mkString)
    println(countPalindromicSubstringsExpand("abc"))
    println(countPalindromicSubstringsExpand("abad"))
    println(countPalindromicSubstringsExpand("abc"))
    println(countPalindromicSubstringsExpand("abccba"))
  }
}
