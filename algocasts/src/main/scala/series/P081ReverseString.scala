package series

import util.StringUtils

/**
 * P81. 反转字符串
 * 这个题目说的是，给你一个字符串，你要写一个函数左右反转它。然后返回反转后的字符串。
 * <pre>
 * 比如说给你的字符串是：
 *
 * abcde
 *
 * 你要返回左右反转后的字符串：
 *
 * edcba
 * </pre>
 */
object P081ReverseString {
  // Time: O(n), Space: O(n)
  def reverseString(s: String): String = {
    if (s == null) return null

    val chars = s.toCharArray
    StringUtils.reverse(chars, 0, chars.length - 1)
    new String(chars)
  }
}
