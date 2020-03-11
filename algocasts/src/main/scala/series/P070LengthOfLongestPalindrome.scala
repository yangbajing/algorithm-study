package series

import scala.collection.mutable

/**
 * P70. 最长回文串的长度
 * https://algocasts.io/series/algo-problems-51-100/episodes/VBpLwqGD
 * 这个题目说的是，给你一个包含大小写英文字母的字符串，你要用这些字母构建一个最长的回文字符串，并返回它的长度。
 * <pre>
 * 比如说，给你的字符串 s 是：
 *
 * aaabccdd
 *
 * 你能用它构建的回文串的最大长度是 7，因此你要返回的就是数字 7。
 *
 * 长度为 7 的回文串有多种构建方式，随便举一种，比如 acdbdca
 * </pre>
 */
object P070LengthOfLongestPalindrome {
  // Time: O(n), Space: O(m)
  def lengthOfLongestPalindrome(s: String): Int = {
    val d = mutable.Map[Char, Int]()
    for (c <- s) {
      d.updateWith(c) {
        case Some(n) => Some(n + 1)
        case None    => Some(1)
      }
    }
    val oddCount = d.valuesIterator.foldLeft(0)((count, n) => if (n % 2 == 1) count + 1 else count)
    val unUsed = math.max(0, oddCount - 1)
    s.length - unUsed
  }
}
