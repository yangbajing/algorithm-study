package series

import scala.collection.mutable

/**
 * P95. 最长连续整数序列的长度
 * https://algocasts.io/series/algo-problems-51-100/episodes/AEpo1MmQ
 * <pre>
 * 这个题目说的是，给你一个无序的整数数组，你要找到数组中元素能够组成的最长连续整数序列，然后返回它的长度。
 *
 * 比如说，给你的数组是 8, 4, 2, 1, 2, 3, 6，这里面的数字能够组成的最长连续整数序列是 1, 2, 3, 4，因此你要返回它的长度 4。
 * </pre>
 */
object P095Longest {
  // Time: O(n*log(n)), Space: O(1)
  def lengthOfLongestConsecutiveSequenceSorting(nums: Array[Int]): Int = {
    java.util.Arrays.sort(nums)
    var max = 0
    var p = 0
    while (p < nums.length) {
      var len = 1
      var goon = true
      while (goon && p < nums.length - 1) {
        val n = nums(p + 1) - nums(p)
        if (n > 1) goon = false
        else {
          if (n == 1) len += 1
          p += 1
        }
      }
      max = math.max(max, len)
      p += 1
    }
    max
  }

  // Time: O(n), Space: O(n)
  def lengthOfLongestConsecutiveSequenceSet(nums: Array[Int]): Int = {
    val set = mutable.Set[Int]() ++ nums
    var max = 0
    for (i <- nums.indices if set.nonEmpty) {
      set.remove(nums(i))
      var low = nums(i) - 1
      var high = nums(i) + 1
      while (set.contains(low)) {
        set.remove(low)
        low -= 1
      }
      while (set.contains(high)) {
        set.remove(high)
        high += 1
      }
      max = math.max(max, high - low - 1)
    }
    max
  }
}
