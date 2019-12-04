package basic

/**
 * P36. 二分搜索
 * https://algocasts.io/series/algo-problems-1-50/episodes/BPp6lmrK
 * 这个题目说的是，给你一个递增排序的整数数组 nums，和一个目标值 target。你要在数组里找到 target，然后返回它的下标。
 * 如果找不到则返回 -1。
 * <pre>
 * 比如说，给你的数组是：
 *
 * -2, 0, 2, 4, 5, 8, 9
 *
 * 给你的目标值是 5。5 在这个数组中，找到后返回它的下标 4 即可。
 * </pre>
 */
object P036BinarySearch {
  // Time: O(log(n)), Space: O(1)
  def binarySearch[T](nums: scala.collection.IndexedSeq[T], target: T)(implicit ev1: T => Ordered[T]): Int = {
    var low = 0
    var high = nums.length - 1
    var result = -1
    while (result == -1 && low <= high) {
      val mid = low + (high - low) / 2
      if (target == nums(mid)) result = mid
      else if (target < nums(mid)) high = mid - 1
      else low = mid + 1
    }
    result
  }
}
