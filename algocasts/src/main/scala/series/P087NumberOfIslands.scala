package series

/**
 * P87. 小岛数量
 * https://algocasts.io/series/algo-problems-51-100/episodes/Yopk3yp3
 * 这个题目说的是，给你一个包含 0/1 字符的二维数组，字符 1 构成的连通区域表示小岛，字符 0 表示海水，你要计算二维数组中有多少个小岛。
 * 在这个题目中，元素相邻只考虑上/下/左/右 4 个元素，斜方向的元素认为是不相邻的。
 * <pre>
 * 比如说，给你的二维数组 g 是：
 *
 * 1 0 0
 * 0 1 1
 * 0 1 1
 *
 * 这个二维数组中，左上角的 1 是一个小岛，右下角 4 个 1 也组成了一个小岛。总共有 2 个小岛，因此你要返回的就是 2。
 * </pre>
 */
object P087NumberOfIslands {
  def numberOfIslands(g: Array[Array[Int]]): Int = {
    if (g == null || g.length == 0) return 0

    val R = g.length
    val C = g(0).length
    var num = 0
    val visits = Array.fill(R, C)(false)

    def dfs(i: Int, j: Int): Unit = if (i < R && j < C && g(i)(j) == 1 && !visits(i)(j)) {
      visits(i)(j) = true
      dfs(i + 1, j)
      dfs(i, j + 1)
      if (i > 0) dfs(i - 1, j)
      if (j > 0) dfs(i, j - 1)
    }

    for {
      i <- 0 until R
      j <- 0 until C
      if g(i)(j) != 0 && !visits(i)(j)
    } {
      num += 1
      dfs(i, j)
    }

    num
  }
}
