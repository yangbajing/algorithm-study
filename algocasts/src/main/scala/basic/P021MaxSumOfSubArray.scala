package basic

import java.util.Objects

/**
 * P21. 连续子序列的最大和
 * https://algocasts.io/series/algo-problems-1-50/episodes/deG4vW1R
 * 这个题目说的是，给你一个非空整数数组，你要找到和最大的连续子序列，然后返回它的和。
 */
object P021MaxSumOfSubArray {
  def maxSubOfSubArray(nums: Iterable[Int]): Int = {
    println(s"maxSubOfSubArray($nums)")
    require(Objects.requireNonNull(nums.nonEmpty))
    val iter = nums.iterator
    var maxSum = Int.MinValue
    var cur = 0
    while (iter.hasNext) {
      val elem = iter.next()
      cur = if (cur <= 0) elem else cur + elem
      maxSum = math.max(maxSum, cur)
      println(s"after, elem: $elem, cur: $cur, maxSum: $maxSum")
    }

    maxSum
  }
}
