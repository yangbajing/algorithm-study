package series

/**
 * P76. 路径数量
 * https://algocasts.io/series/algo-problems-51-100/episodes/Y9pJQNGA
 * 这个题目说的是，给你两个整数 m 和 n，表示的是一个 m x n 的矩阵，任何时候你只能向右或向下移动，那么从矩阵左上角移动到右下角，共有多少条不同的路径。
 * <pre>
 * 比如说，给你的 m = 2，n = 4。简单地画出这个矩阵，使用 0 作为占位符：
 *
 * 0, 0, 0, 0
 * 0, 0, 0, 0
 *
 * 从这个矩阵的左上角走到右下角，共有 4 条不同的路径，因此返回 4。
 * </pre>
 */
object P076UniquePaths {
  // Time: O(m*n), Space: O(m*n)
  def uniquePathsDP(m: Int, n: Int): Int = {
    val d = Array.fill(m, n)(1)
    for {
      i <- 1 until m
      j <- 1 until n
    } d(i)(j) = d(i)(j - 1) + d(i - 1)(j)

    d(m - 1)(n - 1)
  }

  // Time: O(min(m, n)), Space: O(1)
  def uniquePathsMath(m: Int, n: Int): Int = {
    val small = math.min(m - 1, n - 1)
    val total = m + n - 2
    (0 until small)
      .foldLeft(1L) { (result, i) =>
        result * (total - i) / (i + 1)
      }
      .toInt
  }
}
