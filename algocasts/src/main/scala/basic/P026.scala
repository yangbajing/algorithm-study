package basic

import util.StringUtils

/**
 * P26. 最长回文子串
 * https://algocasts.io/series/algo-problems-1-50/episodes/VBpLqWD8
 * 这个题目说的是，给你一个字符串，你要在它所有的回文子串中，找到长度最长的子串，并返回它。
 * <pre>
 * 比如说，给你的字符串是：
 *
 * abcbab
 *
 * 你要返回的最长回文子串是：
 *
 * abcba
 * </pre>
 */
object P026 {
  private def expend(str: String, i: Int, j: Int): Int = {
    var left = i
    var right = j
    while (left >= 0 && right < str.length && str.charAt(left) == str.charAt(right)) {
      left -= 1
      right += 1
    }
    right - left - 1
  }

  def longestPalindrome(s: String): String = {
    if (StringUtils.isEmpty(s)) ""
    else {
      var start = 0
      var maxLen = 0
      var i = 0
      while (i < s.length) {
        val len1 = expend(s, i, i)
        val len2 = expend(s, i, i + 1)
        val len = math.max(len1, len2)
        if (len > maxLen) {
          maxLen = len
          start = i - (len - 1) / 2
        }
        println(s"i:$i, len:$len, maxLen:$maxLen, start:$start")
        i += 1
      }
      s.substring(start, start + maxLen)
    }
  }
}
