package leetcode.p100

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * <pre>
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * </pre>
 */
object P001TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var i = 0
    val iLen = nums.length - 1
    val len = nums.length
    while (i < iLen) {
      var j = i + 1
      while (j < len) {
        if (nums(i) + nums(j) == target) {
          return Array(i, j)
        }
        j += 1
      }
      i += 1
    }

    Array(-1, -1)
  }
}
