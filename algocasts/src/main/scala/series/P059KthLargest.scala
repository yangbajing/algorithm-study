package series

/**
 * P59. 数组中第 K 大的元素
 * https://algocasts.io/series/algo-problems-51-100/episodes/vkmelbWb
 * 这个题目说的是，给你一个整数数组和一个整数 K，你要找到数组中第 K 大的元素。
 * <pre>
 * 比如说，给你的整数数组是：
 *
 * 4, 2, 8, 1, 8
 *
 * 整数 K 是 2。这个数组中第 2 大的元素是 8，因此你要返回 8。
 * </pre>
 */
object P059KthLargest {
  // Time: O(n*log(k)), Space: O(k)
  def findKthLargestMinHeap(nums: Array[Int], k: Int): Int = {
    new P057KthLargestElement.KthLargestElement(nums, k).max.getOrElse(-1)
  }

  // Time(avg): O(n), Time(worst): O(n^2), Space: O(1)
  def findKthLargestQuickSelect(nums: Array[Int], k: Int): Int = {
    var low = 0
    var high = nums.length - 1
    while (low <= high) {
      val p = partition(nums, low, high)
      if (p == k - 1) return nums(p)
      else if (p > k - 1) high = p - 1
      else low = p + 1
    }
    -1
  }

  private def partition(arr: Array[Int], low: Int, high: Int): Int = {
    val pivot = arr(low)
    var l = low
    var h = high
    while (l < h) {
      while (l < h && arr(h) < pivot) h -= 1
      if (l < h) swap(arr, l, h)
      while (l < h && arr(l) >= pivot) l += 1
      if (l < h) swap(arr, l, h)
    }
    l
  }
}
