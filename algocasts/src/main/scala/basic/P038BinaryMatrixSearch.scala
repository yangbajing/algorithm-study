package basic

import scala.collection.IndexedSeq

/**
 * P38. 二维数组的二分搜索
 * https://algocasts.io/series/algo-problems-1-50/episodes/ezplkGEn
 * 这个题目说的是，给你一个二维数组 matrix，和一个目标值 target。你要在数组里找到这个目标值，然后返回它的行/列下标。
 * 如果找不到，则返回 [-1,-1]。
 *
 * 这个数组的每一行都是递增的，并且每一行的第一个数都比上一行的最后一个数要大。也就是，这个数组可以看成，
 * 从左到右、从上到下，呈 Z 字形递增。
 * <pre>
 * 比如说，给你的二维数组是：
 *
 * 1, 3, 5
 * 7, 9, 11
 *
 * 给你的目标值是 9。9 在这个数组中，找到后返回它的下标 [1, 1] 即可。
 *
 * 如果给你的目标值是 100。显然它不在这个二维数组中，你要返回 [-1，-1]。
 * </pre>
 */
object P038BinaryMatrixSearch {
  def binarySearch[T](matrix: IndexedSeq[IndexedSeq[T]], target: T)(implicit ev1: T => Ordered[T]): Array[Int] = {
    if (matrix == null || matrix.isEmpty || matrix(0) == null || matrix(0).isEmpty) Array(-1, -1)
    else {
      var idx = Array(-1, -1)
      val ROW = matrix.length
      val COL = matrix(0).length
      var low = 0
      var high = ROW * COL - 1
      while (idx(0) == -1 && low <= high) {
        val mid = low + (high - low) / 2
        val r = mid / COL
        val c = mid % COL
        val v = matrix(r)(c)
        if (v < target) low = mid + 1
        else if (v > target) high = mid - 1
        else idx = Array(r, c)
      }
      idx
    }
  }
}
