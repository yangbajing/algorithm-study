package series

import basic.P012Palindromic.expand
import util.StringUtils

import scala.collection.mutable.ListBuffer

/**
 * P69. 回文分割
 * https://algocasts.io/series/algo-problems-51-100/episodes/XOp1wZm2
 * 这个题目说的是，给你一个字符串，你要把它分割成子串，并且每个子串都是回文串。你要返回所有可能的子串集合。
 * <pre>
 * 比如说，给你的字符串是：
 *
 * aad
 *
 * 它有两种可能的分割方法。一种是分割成 aa 和 d。aa 是回文串，d 作为单个字符也是回文串。
 *
 * 另一种是分割成 a，a 和 d，3 个子串都是单字符的回文串。
 * </pre>
 * 相关视频：12. 回文子串个数
 */
object P069PalindromicSplit {
  def partition(s: String): ListBuffer[Seq[String]] = {
    val result = ListBuffer[Seq[String]]()
    if (StringUtils.isBlank(s)) return result

    val n = s.length
    val d = Array.ofDim[Boolean](n, n)
    for {
      i <- n - 1 to 0 by -1 // From the last end to the left.
      j <- i until n // From the i to the s.length.
    } {
      d(i)(j) =
        if (i == j) true // Point to the same character.
        else if (i + 1 == j) s.charAt(i) == s.charAt(j) // substring[i, j] length is 3, so s(i) == s(j) is palindromic.
        else s.charAt(i) == s.charAt(j) && d(i + 1)(j - 1) // s(i) == s(j) and substring[(]i+1, j-1] is palindromic.
    }

    partition(s, 0, d, result, ListBuffer())

    result
  }

  private def partition(
      s: String,
      start: Int,
      d: Array[Array[Boolean]],
      result: ListBuffer[Seq[String]],
      elem: ListBuffer[String]): Unit = {
    if (start >= s.length) {
      println(s"elem: $elem")
      result.addOne(elem.toSeq)
    } else {
      for (end <- start until s.length if d(start)(end)) {
        val find = s.substring(start, end + 1)
        elem.addOne(find)
        partition(s, end + 1, d, result, elem)
        elem.remove(elem.size - 1) // Time: O(1)
      }
    }
  }

  def expand(s: String): Seq[String] = {
    var result = Vector[String]()
    if (StringUtils.isEmpty(s)) return result

    def expand(l: Int, r: Int): Unit = {
      var left = l
      var right = r
      while (left >= 0 && right < s.length && s.charAt(left) == s.charAt(right)) {
        result :+= s.substring(left, right + 1)
        left -= 1
        right += 1
      }
    }

    for (i <- 0 until s.length) {
      expand(i, i)
      expand(i, i + 1)
    }

    result
  }
}
