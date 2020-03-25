package series

/**
 * P89. 需要排序的最短子数组
 * https://algocasts.io/series/algo-problems-51-100/episodes/4rpa6qWZ
 * 这个题目说的是，给你一个整数数组，你要找到一个最短的子数组，只要把它按递增排序，那么整个数组就变成递增有序。
 * 最后返回这个最短子数组的长度。注意，子数组要求是连续的。
 *
 * 比如说，给你的数组是 0, 2, 4, 1, 8。我们至少需要把子数组 2, 4, 1 排序，变成 1, 2, 4，才能使得整个数组有序。
 * 因此要返回这个子数组的长度 3。
 */
object P089Subarray {
  // Time: O(n), Space: O(1)
  def subarrayOnePass(nums: Array[Int]): Int = {
    if (nums == null || nums.length == 0) return 0

    val N = nums.length
    var left = 0
    var right = -1
    var max = Int.MinValue
    var min = Int.MaxValue

    for (k <- 0 until N) {
      max = math.max(max, nums(k))
      if (nums(k) != max) right = k

      val p = N - 1 - k
      min = math.min(min, nums(p))
      if (nums(p) != min) left = p
    }

    right - left + 1
  }

  // Time: O(2n), Space: O(1)
  def subarrayTwoPass(nums: Array[Int]): Int = {
    if (nums == null || nums.length == 0) return 0

    val N = nums.length
    var left = 0
    var right = N - 1

    while (left < N - 1 && nums(left) < nums(left + 1)) left += 1
    while (right > 0 && nums(right - 1) < nums(right)) right -= 1

    var max = Int.MinValue
    var min = Int.MaxValue
    for (k <- left to right) {
      min = math.min(min, nums(k))
      max = math.max(max, nums(k))
    }

    while (left >= 0 && min < nums(left)) left -= 1
    while (right < N && max > nums(right)) right += 1

    math.max(right - left - 1, 0)
  }

  // Time: O(n*log(n)), Space: O(n)
  def subarrayBySorting(nums: Array[Int]): Int = {
    if (nums == null || nums.length == 0) return 0

    val N = nums.length
    var left = 0
    var right = N - 1
    val copy = nums.clone()
    java.util.Arrays.sort(copy)

    while (left < N && nums(left) == copy(left)) left += 1
    while (right >= 0 && nums(right) == copy(right)) right -= 1

    math.max(right - left + 1, 0)
  }
}
