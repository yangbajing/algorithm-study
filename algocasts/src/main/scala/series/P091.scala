package series

/**
 * P91. 旋转有序数组的搜索
 * 这个题目说的是，给你一个旋转有序的整数数组，和一个目标值，你要在数组里找到目标值，然后返回它的下标。如果找不到则返回 -1。
 * 注意：数组中不存在重复数字。旋转有序数组是由一个原来有序的数组通过左旋或右旋部分数字到另一端形成的。注意，这里我们讨论的有序默认都指递增排序。
 * <pre>
 * 比如说，原来的有序数组是：
 *
 * 1, 2, 3, 4, 5, 6, 7, 8
 *
 * 把 1, 2, 3, 4 旋转到数组右边，得到的数组 a 是：
 *
 * 5, 6, 7, 8, 1, 2, 3, 4
 *
 * 假如给你的目标值是 6，则要返回它的下标 1；假如给你的目标值是 0，0 不在这个数组中，因此返回 -1。
 * </pre>
 */
object P091 {
  def searchInRotatedSortedArray(nums: IndexedSeq[Int], target: Int): Int = {
    if (nums == null || nums.isEmpty) return -1

    var low = 0
    var high = nums.length - 1
    while (low < high) {
      val mid = low + (high - low) / 2
      val m = nums(mid)
      if (target == m) return mid

      if (m >= nums(low)) {
        if (target < m && target >= nums(low)) high = mid - 1
        else low = mid + 1
      } else {
        if (target > m && target <= nums(high)) low = mid + 1
        else high = mid - 1
      }
    }

    -1
  }
}
