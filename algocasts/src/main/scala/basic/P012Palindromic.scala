package basic

import util.StringUtils

/**
 * P12. 回文子串个数
 * https://algocasts.io/series/algo-problems-1-50/episodes/dbGY2p5V
 * 这个题目说的是，给你一个字符串，你要计算出它所包含的回文子串个数。只要起始下标或终止下标不同，即使子串相同，我们也认为是不同的回文子串。
 * <pre>
 * 比如说，给你的字符串是：
 *
 * abc
 *
 * 这个字符串中总共有 3 个回文子串，分别是 a， b 和 c。因此你要返回的个数是 3。
 *
 * 再比如说，给你的字符串是：
 *
 * aba
 *
 * 这个字符串中总共有 4 个回文子串，分别是 a，b，a，和 aba。因此你要返回的个数是 4。
 * </pre>
 */
object P012Palindromic {
  // Time: O(n^2), Space: O(n^2)
  def countPalindromicSubstringsDP(s: String): Int = {
    if (StringUtils.isEmpty(s)) return 0

    val n = s.length
    val d = Array.ofDim[Boolean](n, n)
    var count = 0

    for {
      i <- n - 1 to 0 by -1 // From the last end to the left.
      j <- i until n // From the i to the s.length.
    } {
      d(i)(j) =
        if (i == j) true // Point to the same character.
        else if (i + 1 == j) s.charAt(i) == s.charAt(j) // substring[i, j] length is 3, so s(i) == s(j) is palindromic.
        else s.charAt(i) == s.charAt(j) && d(i + 1)(j - 1) // s(i) == s(j) and substring[(]i+1, j-1] is palindromic.
      println(s"d($i)($j) == ${d(i)(j)}")
      if (d(i)(j)) count += 1
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
    for (i <- 0 until s.length) {
      count += expand(s, i, i)
      count += expand(s, i, i + 1)
    }

    count
  }
}
