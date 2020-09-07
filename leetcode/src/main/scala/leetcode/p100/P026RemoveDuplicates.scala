package leetcode.p100

/**
 * @author yangbajing <a href="mailto://yang.xunjing@qq.com">羊八井</a>
 * @date 2020-09-07 21:24
 */
object P026RemoveDuplicates {
  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums == null || nums.length == 0) return 0

    var i = 0
    for (c <- nums.tail if nums(i) != c) {
      i += 1
      nums(i) = c
    }
    i + 1
  }

  def removeDuplicates2(nums: Array[Int]): Int = {
    if (nums == null || nums.length == 0) return 0

    var i = 0
    var j = 1
    while (j < nums.length) {
      if (nums(i) != nums(j)) {
        i += 1
        nums(i) = nums(j)
      }
      j += 1
    }
    i + 1
  }
}
