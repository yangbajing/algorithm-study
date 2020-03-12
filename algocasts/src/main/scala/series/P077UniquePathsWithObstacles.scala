package series

/**
 * P77. 路径数量（含障碍物）
 * https://algocasts.io/series/algo-problems-51-100/episodes/qjG08bGK
 * 这个题目说的是，给你一个矩阵，矩阵元素有 0 和 1 两种值。0 表示矩阵中这个格子是空的，可以走；1 表示这个格子里有障碍物，不能走。
 * 你在这个矩阵中只能向右或向下走，那么从矩阵左上角走到右下角，共有多少条不同的路径。
 * <pre>
 * 比如说给你的矩阵是：
 *
 *  0, 0, 1, 0
 *  0, 0, 0, 0
 *
 * 第 0 行的 1 表示那里有个障碍物，不能走。从这个矩阵的左上角走到右下角，共有 2 条不同的路径，因此要返回 2。
 * </pre>
 */
object P077UniquePathsWithObstacles {
  // Time: O(m*n), Space: O(m*n)
  def uniquePaths(row: Int, col: Int, obstacle: (Int, Int)): Int = {
    val d = Array.ofDim[Int](row, col)
    d(0)(0) = if (obstacle == (0, 0)) 0 else 1
    (1 until col).foreach(c => d(0)(c) = if (obstacle == (0, c)) 0 else d(0)(c - 1))
    (1 until row).foreach(r => d(r)(0) = if (obstacle == (r, 0)) 0 else d(r - 1)(0))
    for {
      r <- 1 until row
      c <- 1 until col
    } d(r)(c) = d(r)(c - 1) + d(r - 1)(c)
    d(row - 1)(col - 1)
  }

  // Time: O(m*n), Space: O(min(m, n))
  def uniquePathsOn(row: Int, col: Int, obstacle: (Int, Int)): Int = {
    val d = Array.ofDim[Int](math.min(row, col))
    d(0) = if (obstacle == (0, 0)) 0 else 1
    val byRow = d.length == col
    val (m, n) = if (byRow) (row, col) else (col, row)

    for (i <- 0 until m) {
      val first = if (byRow) (i, 0) else (0, i)
      d(0) = if (obstacle == first) 0 else d(0)
      for (j <- 1 until n) {
        val second = if (byRow) (i, j) else (j, i)
        d(j) = if (obstacle == second) 0 else d(j) + d(j - 1)
      }
    }

    d(d.length - 1)
  }
  // Time: O(m*n), Space: O(min(col))
  def uniquePathsByCol(row: Int, col: Int, obstacle: (Int, Int)): Int = {
    val d = Array.ofDim[Int](col)
    d(0) = if (obstacle == (0, 0)) 0 else 1

    for (i <- 0 until row) {
      d(0) = if (obstacle == (i, 0)) 0 else d(0)
      for (j <- 1 until col) {
        d(j) = if (obstacle == (i, j)) 0 else d(j) + d(j - 1)
      }
    }

    d(d.length - 1)
  }
}
