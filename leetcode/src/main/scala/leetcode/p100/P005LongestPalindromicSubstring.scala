package leetcode.p100

object P005LongestPalindromicSubstring {
  def longestPalindrome(s: String): String = {
    if (s == null || s.length < 1) {
      return s
    }

    var start = 0
    var end = 0
    var i = 0
    while (i < s.length) {
      val len1 = expandAroundCenter(s, i, i)
      val len2 = expandAroundCenter(s, i, i + 1)
      val len = math.max(len1, len2)
      if (len > end - start) {
        start = i - (len - 1) / 2
        end = i + len / 2
      }

      i += 1
    }

    s.substring(start, end + 1)
  }

  private def expandAroundCenter(s: String, left: Int, right: Int): Int = {
    var l = left
    var r = right
    while (l >= 0 && r < s.length && s.charAt(l) == s.charAt(r)) {
      l -= 1
      r += 1
    }
    r - l - 1
  }
}
