package series

import util.StringUtils

/**
 * P83. 反转单词
 * 这个题目说的是，给你一个字符串，你要写一个函数反转这个字符串中的单词，然后返回处理后的字符串。注意，单词之间只用一个空格隔开。
 * <pre>
 * 比如说给你的字符串是：
 *
 * "I am busy."
 *
 * 反转这个字符串中的 3 个单词，得到：
 *
 * "I ma .ysub"
 *
 * 注意，最后的句号要连同单词一起反转。
 * </pre>
 */
object P083ReverseWords {
  // Time: O(n), Space: O(n)
  def reverseWords(s: String): String = {
    if (StringUtils.isBlank(s)) return s

    val ch = s.toCharArray
    var start = 0
    var end = 0
    while (end < ch.length) {
      while (end < ch.length && ch(end) != ' ') end += 1

      StringUtils.reverse(ch, start, end - 1)
      end += 1
      start = end
    }
    new String(ch)
  }
}
