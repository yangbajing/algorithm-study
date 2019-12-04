package basic

/**
 * P50. 矩阵置零
 * https://algocasts.io/series/algo-problems-1-50/episodes/nwp8gDG7
 * 这个题目说的是，给你一个 m x n 的矩阵，你要把这个矩阵中等于 0 的元素所在的行和列都置 0。
 * <pre>
 * 比如说，给你的矩阵 a 是：
 *
 *  1, 2, 3
 *  4, 0, 6
 *  0, 8, 9
 *
 * 这个矩阵中有两个 0，把它们所在的行和列都置 0 后，得到的矩阵是：
 *
 *  0, 0, 3
 *  0, 0, 0
 *  0, 0, 0
 *  </pre>
 */
object P050SetZeroInMatrix {
  // Time: O(m*n), Space: O(1)
  def setZeroInMatrixO1[T](matrix: Array[Array[T]])(implicit num: Numeric[T]): Unit = {
    val rowLen = matrix.length
    val colLen = matrix(0).length
    val row0 = matrix(0).contains(num.zero)
    val col0 = matrix.exists(arr => arr(0) == num.zero)

    for (i <- 1 until rowLen) {
      for (j <- 1 until colLen if matrix(i)(j) == num.zero) {
        matrix(i)(0) = num.zero
        matrix(0)(j) = num.zero
      }
    }
    for (i <- 1 until rowLen) {
      for (j <- 1 until colLen if matrix(i)(0) == num.zero || matrix(0)(j) == num.zero)
        matrix(i)(j) = num.zero
    }

    if (row0) (0 until colLen).foreach(j => matrix(0)(j) = num.zero)
    if (col0) (0 until rowLen).foreach(r => matrix(r)(0) = num.zero)
  }
}
