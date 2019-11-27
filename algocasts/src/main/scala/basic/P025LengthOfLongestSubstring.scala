package basic

import util.StringUtils

import scala.collection.mutable

/**
 * P25. 没有重复字符的最长子串长度
 * https://algocasts.io/series/algo-problems-1-50/episodes/XOp1ZW2e
 * 这个题目说的是，给你一个字符串，你要找到没有重复字符的最长子串，然后返回它的长度。
 * <pre>
 * 比如说给你的字符串 s 是：
 *
 * abcabcbb
 *
 * 没有重复字符的最长子串是 abc，这里再往下的字符是 a，和前面这个 a 重复了。
 *
 * 后面满足条件的子串还有 bca，cab，abc 等，不过它们的长度都是 3 ，因此返回的长度为 3。
 *
 * 再比如说 ddd，没有重复字符的最长子串就是一个 d，因此你要返回的长度是 1。
 * </pre>
 */
object P025LengthOfLongestSubstring {
  def lengthOfLongestSubstring(s: String): Int = {
    println(s"lengthOfLongestSubstring($s)")
    require(StringUtils.nonEmpty(s))
    val index = mutable.Map.empty[Char, Int]
    var maxLen = 0
    var i = 0
    var j = 0
    while (j < s.length) {
      val c = s.charAt(j)
      // max(c字符索引的后一位置, i)
      i = math.max(index.getOrElse(c, -1) + 1, i)
      maxLen = math.max(maxLen, j - i + 1)
      println(s"j:$j, c:$c, i:$i, maxLen:$maxLen, $index")
      index.put(c, j)
      j += 1
    }

    maxLen
  }
}
