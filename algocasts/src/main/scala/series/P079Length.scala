package series

/**
 * P79. 最长递增子序列的长度
 * https://algocasts.io/series/algo-problems-51-100/episodes/yRp3Mym4
 * 这个题目说的是，给你一个整数数组，你要计算数组里最长递增子序列的长度。其中，子序列不要求连续。
 * <pre>
 * 比如说，给你的数组 a 是：
 *
 * 1, 8, 2, 6, 4, 5
 *
 * 在这个数组里，最长的递增子序列是：
 *
 * 1, 2, 4, 5
 *
 * 因此你要返回它的长度 4。
 * </pre>
 */
object P079Length {
  // Time: O(n^2), Space: O(n)
  def lengthOfLISDP(nums: IndexedSeq[Int]): Int = {
    if (nums == null || nums.isEmpty) return 0

    val n = nums.length
    var max = 1
    val d = Array.ofDim[Int](n)
    d(0) = 1
    for (i <- 1 until n) {
      // d(i) 与从 j = [0, i) 的每个数比较，如果大于则取 d(j) + 1，否则子序列长度为1
      for (j <- 0 until i) {
        val cur = if (nums(i) > nums(j)) d(j) + 1 else 1
        d(i) = math.max(max, cur)
      }
      max = math.max(max, d(i))
    }
    max
  }

  // Time: O(n*lg(n)), Space: O(n)
  def lengthOfLISBinarySearch(nums: IndexedSeq[Int]): Int = {
    if (nums == null || nums.isEmpty) return 0

    def binarySearchInsertPosition(d: Array[Int], len: Int, x: Int): Int = {
      var low = 0
      var high = len - 1
      while (low <= high) {
        val mid = low + (high - low) / 2
        val v = d(mid)
        println(s"low: $low, high: $high, mid: $mid, v: $v, x: $x")
        if (x < v) high = mid - 1
        else if (x > v) low = mid + 1
        else return mid
      }
      low
    }

    val n = nums.length
    var len = 0
    val d = Array.ofDim[Int](n)
    for (x <- nums) {
      val i = binarySearchInsertPosition(d, len, x)
      d(i) = x
      if (i == len) len += 1
      println(s"i: $i, len: $len, x: $x")
    }
    len
  }
}
