package series

/**
 * P66. 帕斯卡三角形
 * https://algocasts.io/series/algo-problems-51-100/episodes/jwmBr5m8
 * 这个题目说的是，给你一个非负整数 n，你要返回帕斯卡三角形的前 n 行。帕斯卡三角形又称为杨辉三角形，它的特点是左右两条边上的数字都为 1，
 * 其它位置的数字等于左上方与右上方的两个数字之和。
 * <pre>
 * 比如说，给你的数字是 5，你要返回帕斯卡三角形的前 5 行。
 *
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * </pre>
 */
object P066PascalTriangle {
  // Time: O(n^2), Space: O(1)
  def pascalTriangle(n: Int): Array[Array[Int]] = {
    require(n > 0, "n must greater than 0!")
    val result = Array.ofDim[Array[Int]](n)
    result(0) = Array(1)
    (1 until n).foreach { i =>
      val arr = Array.fill(i + 1)(1)
      val pre = result(i - 1)
      (1 until pre.length).foreach(j => arr(j) = pre(j - 1) + pre(j))
      result(i) = arr
    }
    result
  }
}
