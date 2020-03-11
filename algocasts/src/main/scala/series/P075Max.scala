package series

/**
 * P75. 连续子序列的最大乘积
 * https://algocasts.io/series/algo-problems-51-100/episodes/k8GNBaGe
 * 这个题目说的是，给你一个整数数组，你要找到乘积最大的连续子序列，然后返回它的乘积。
 * <pre>
 * 比如说，给你的数组是：
 *
 * 8, 1, -2, 4, -1
 *
 * 这个数组中连续子序列的最大乘积是 64，连续子序列就是数组本身。
 * </pre>
 */
object P075Max {
  // Time: O(n), Space: O(1)
  def maxProductSubseq[T](list: Iterable[T])(implicit nums: Numeric[T]): T = {
    import nums._
    if (list == null || list.isEmpty) return nums.zero

    val iter = list.iterator
    var curMax = iter.next()
    var curMin = curMax
    var max = curMax

    while (iter.hasNext) {
      val c = iter.next()
      val a = curMax * c
      val b = curMin * c
      curMax = a.max(b).max(c)
      curMin = a.min(b).min(c)
      max = max.max(curMax)
    }

    max
  }
}
