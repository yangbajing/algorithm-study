package series

/**
 * P54. 实现平方根函数
 * https://algocasts.io/series/algo-problems-51-100/episodes/Z5mzEJWd
 * 这个题目说的是，你要实现一个函数，来计算非负整数 n 的平方根，平方根只需返回整数部分即可。
 * <pre>
 * 比如，使用你实现的函数来计算 9 的平方根是 3：
 *
 * f(9) = 3
 *
 * 由于 8 的平方根是 2 点几，使用你实现的函数只需要返回整数部分 2 即可：
 *
 * f(8) = 2
 * </pre>
 */
object P054AlgoCasts {
  // Time: O(log(n)), Space: O(1)
  def sqrtNewton(n: Int): Int = {
    var x = n
    while (x * x > n) x = (x + n / x) / 2
    x
  }
}
