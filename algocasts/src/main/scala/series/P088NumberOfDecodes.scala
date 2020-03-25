package series

/**
 * P88. 解码方式
 * https://algocasts.io/series/algo-problems-51-100/episodes/n5Gqb4pA
 * 这个题目说的是，给你一个加密后的非空字符串，原字符串由大写 A 到 Z 组成，加密后的字符串由数字字符组成，
 * 加密方法是把大写 A 到 Z 映射成 1 到 26。你要计算出给你的加密字符串有多少种可能的解码方式。
 * <pre>
 * 比如说，给你的加密字符串是："124"。这个数字字符串有 3 种解码方式：
 *
 * 1. 第一种是 "124" 各解码成一个字符，得到 ABD
 * 2. 第二种是 "12" 和 "4" 各解码成一个字符，得到 LD
 * 3. 第三种是 "1" 和 "24" 各解码成一个字符，得到 AX
 *
 * 因此，你要返回的答案就是 3 种。
 *
 * 映射关系：
 * A -> 1
 * B -> 2
 * ...
 * Z -> 26
 * </pre>
 */
object P088NumberOfDecodes {
  // Time: O(n), Space: O(1)
  def numberOfDecodesDPO1(s: String): Int = {
    var first = 1
    var second = if (s.charAt(0) == '0') 0 else 1

    for (i <- 2 to s.length) {
      var tmp = 0
      if (s.charAt(i - 1) != '0') tmp += second
      if (isValid(s.charAt(i - 2), s.charAt(i - 1))) tmp += first

      first = second
      second = tmp
    }

    second
  }

  // Time: O(n), Space: O(n)
  def numberOfDecodesDP(s: String): Int = {
    val d = Array.fill(s.length + 1)(0)
    d(0) = 1
    d(1) = if (s.charAt(0) == '0') 0 else 1

    for (i <- 2 to s.length) {
      if (s.charAt(i - 1) != '0') d(i) += d(i - 1)
      if (isValid(s.charAt(i - 2), s.charAt(i - 1))) d(i) += d(i - 2)
    }

    d(s.length)
  }

  def numberOfDecodesRecursive(s: String): Int = {
    def decode(i: Int): Int = {
      if (i == s.length) 1
      else if (i > s.length) 0
      else {
        var num = 0
        if (s.charAt(i) != '0') num += decode(i + 1)
        if (i + 1 < s.length && isValid(s.charAt(i), s.charAt(i + 1))) num += decode(i + 2)
        num
      }
    }

    decode(0)
  }

  private def isValid(a: Char, b: Char) = (a == '1' && b <= '9') || (a == '2' && b <= '6')
}
