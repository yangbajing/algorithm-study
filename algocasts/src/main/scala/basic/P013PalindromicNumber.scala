package basic

/**
 * P13. 回文数字判断
 * https://algocasts.io/series/algo-problems-1-50/episodes/zbmKMpZq
 * 这个题目说的是，给你一个整数，你要判断它是否是一个回文数字。所谓回文数字就是，你正着读和反着读都是同一个数字。
 * <pre>
 * 比如，给你的数字是：
 *
 * 12321
 *
 * 无论你从左向右读，还是从右向左读，都是 12321，所以它是一个回文数字，你要返回 true。
 *
 * 再比如说：
 *
 * -232
 *
 * 你从左向右读是 -232，但从右向左读则是 232-，和 -232 不一样，因此它不是一个回文数字，你要返回 false。
 * </pre>
 */
object P013PalindromicNumber {
  def isPalindromeString(x: Int): Boolean = {
    val s = x.toString
    var i = 0
    var j = s.length - 1
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) return false

      i += 1
      j -= 1
    }
    true
  }

  // Time: O(m), Space: O(1)
  def isPalindrome(x: Int): Boolean = {
    if (x < 0) return false

    var tmp = x
    var y = 0
    while (tmp != 0) {
      val num = tmp % 10
      y = y * 10 + num
      tmp = tmp / 10
      println(s"y: $y, tmp: $tmp")
    }

    y == x
  }

  def main(args: Array[String]): Unit = {
    println(isPalindromeString(1231))
    println(isPalindromeString(121))
    println(isPalindromeString(12321))
    println(Vector.fill(80)('-').mkString)
    println(isPalindrome(1231))
    println(isPalindrome(121))
    println(isPalindrome(12321))
  }
}
