package basic

import util.StringUtils

/**
 * P43. 实现 strstr
 * https://algocasts.io/series/algo-problems-1-50/episodes/Yopkym35
 * 这个题目说的是，你要实现 C 语言里面的 strstr 函数，这个函数接收两个字符串，
 * 你要找到第二个字符串在第一个字符串中的开始下标，如果找不到则返回 -1。
 * <pre>
 * 比如说，给你的两个字符串分别是：
 *
 * marvel studio 和 studio
 *
 * 第二个字符串存在于第一个字符串中，于是你要返回它在第一个字符串中的开始下标 7。
 *
 * 再比如说给你的字符串是：
 *
 * doctor strange 和 master
 *
 * 第二个字符串没有在第一个字符串中出现，因此返回 -1。
 * </pre>
 */
object P043strstr {
  // Time: O((n-m+1)*m), Space: O(1)
  def strstr(haystack: String, needle: String): Int = {
    if (StringUtils.isEmpty(needle)) 0
    else if (StringUtils.isEmpty(haystack) || haystack.length < needle.length) -1
    else _strstr(haystack, needle)
  }

  def _strstr(haystack: String, needle: String): Int = {
    val n = haystack.length
    val m = needle.length
    for (i <- 0 to n - m) {
      var k = i
      var j = 0
      //println(s"i:$i, k:$k, j:$j; ${haystack.charAt(k)} == ${needle.charAt(j)}")
      while (j < m && k < n && haystack.charAt(k) == needle.charAt(j)) {
        k += 1
        j += 1
      }
      if (j == m) return i
    }
    -1
  }
}
