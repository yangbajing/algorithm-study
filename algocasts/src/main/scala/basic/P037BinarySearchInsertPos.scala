package basic

/**
 * P37. 二分搜索插入位置
 * https://algocasts.io/series/algo-problems-1-50/episodes/dlWbxGvA
 * 这个题目说的是，给你一个递增排序的整数数组 nums，和一个目标值 target。你要在数组里找到 target，然后返回它的下标。
 * 如果找不到，则返回目标值应该插入的位置的下标，要求插入目标值后，数组仍然保持有序。
 */
object P037BinarySearchInsertPos {
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
    low
  }
}
