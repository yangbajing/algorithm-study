package series

import scala.reflect.ClassTag

/**
 * P51. 最小路径和
 * https://algocasts.io/series/algo-problems-51-100/episodes/AEpoAMmQ
 * 这个题目说的是，给你一个 m x n 的整数矩阵，你要计算从矩阵的左上角到右下角的所有路径中，最小的路径和。路径的移动方向只能是向右或向下。
 * <pre>
 * 比如说，给你的矩阵 a 是：
 *
 *  1, 2, 1
 *  8, 4, 1
 * -8, 2, 1
 *
 * 对于这个矩阵，从左上角走到右下角，和最小的一条路径是 1,8,-8,2,1，它的和是 4，因此你需要返回 4。
 * </pre>
 */
object P051MinSumOfPath {
  // Time: O(m*n), Space: O(n)
  def minSumOfPath1dIterative[T: ClassTag](a: Iterable[Iterable[T]])(implicit nums: Numeric[T]): T = {
    val firstRow = a.head
    val d = firstRow.view.tail.scan(firstRow.head)(nums.plus).toArray
    for (row <- a.view.tail) {
      val colIter = row.iterator
      d(0) = nums.plus(d(0), colIter.next())
      for (c <- 1 until d.length) d(c) = nums.plus(nums.min(d(c), d(c - 1)), colIter.next())
    }
    d.last
  }

  // Time: O(m*n), Space: O(m*n)
  def minSumOfPath[T: ClassTag](a: scala.collection.IndexedSeq[scala.collection.IndexedSeq[T]])(
      implicit nums: Numeric[T]): T = {
    val ROW = a.length
    val COL = a(0).length
    val d = Array.ofDim[T](ROW, COL)

    d(0)(0) = a(0)(0)
    1 until ROW foreach (r => d(r)(0) = nums.plus(d(r - 1)(0), a(r)(0)))
    1 until COL foreach (c => d(0)(c) = nums.plus(d(0)(c - 1), a(0)(c)))

    for {
      r <- 1 until ROW
      c <- 1 until COL
    } d(r)(c) = nums.plus(nums.min(d(r - 1)(c), d(r)(c - 1)), a(r)(c))

    d.last.last
  }

  // Time: O(m*n), Space: O(n)
  def minSumOfPath1dIndex[T: ClassTag](a: Array[Array[T]])(implicit nums: Numeric[T]): T = {
    val ROW = a.length
    val COL = a(0).length
    val d = Array.ofDim[T](COL)

    d(0) = a(0)(0)
    1 until COL foreach (r => d(r) = nums.plus(d(r - 1), a(0)(r)))
    for (r <- 1 until ROW) {
      d(0) = nums.plus(d(0), a(r)(0))
      for (c <- 1 until COL) d(c) = nums.plus(nums.min(d(c), d(c - 1)), a(r)(c))
    }

    d.last
  }
}
