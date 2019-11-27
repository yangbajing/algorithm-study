package basic

/**
 * P23. 数组中超过一半的数字
 * https://algocasts.io/series/algo-problems-1-50/episodes/VlWd8W06
 * 这个题目说的是，给你一个数组，里面有一个数字出现的次数超过了一半，你要找到这个数字并返回。
 * <pre>
 * 比如说，给你的数组是
 *
 * 1, 3, 3, 1, 3, 1, 1
 *
 * 这个数组的长度是 7，这里我们只考虑整数除法，长度 7 除以 2 是 3。数组里面 1 出现了 4 次，超过了一半的数量 3，因此你要返回的就是 1。
 * </pre>
 */
object P023Majority {
  // Time: O(n), Space: O(1)
  def getMajority(nums: Iterable[Int]): Int = {
    require(nums.nonEmpty)
    val (result, _) = nums.tail.foldLeft((nums.head, 1)) {
      case ((_, 0), cur)                     => (cur, 1)
      case ((num, count), cur) if num == cur => (num, count + 1)
      case ((num, count), _)                 => (num, count - 1)
    }
    result
  }
}
