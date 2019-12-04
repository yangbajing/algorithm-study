package basic

/**
 * P41. 丑数
 * https://algocasts.io/series/algo-problems-1-50/episodes/8eGx3mMO
 * 这个题目说的是，给你一个数字，你要判断它是不是一个丑数。丑数的定义是质因数只包含 2，3，5 的正整数。
 * 另外，1 作为特例，也定义为丑数。
 * <pre>
 * 比如说给你的数字是 45，45 做质因数分解，可以写成：
 *
 * 45 = 3 x 3 x 5
 *
 * 不包含 2，3，5 以外的质因数，因此它是一个丑数。
 *
 * 再比如说 42，它做质因数分解得到：
 *
 * 42 = 2 x 3 x 7
 *
 * 7 不在 2，3，5 中，因此 42 不是丑数。
 * </pre>
 */
object P041UglyNumber {
  // Time: O(m+n+l), Space: O(1)
  def isUglyNumber(num: Int): Boolean = {
    if (num > 0) {
      var n = num
      while (n % 2 == 0) n /= 2
      while (n % 3 == 0) n /= 3
      while (n % 5 == 0) n /= 5
      n == 1
    } else false
  }
}
