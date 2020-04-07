package series

import scala.collection.mutable

/**
 * P93. 滑动窗口中的最大值
 * https://algocasts.io/series/algo-problems-51-100/episodes/XZWvPBG7
 * 这个题目说的是，给你一个整数数组和整数 k，k 表示滑动窗口的大小，滑动窗口从左向右滑过数组，每移动一个位置，
 * 你要计算出当前滑动窗口内 k 个数字的最大值。最后返回这个最大值数组。
 * <pre>
 * 比如说，给你的数组是 0, 4, 2, 1, 0, 8, 2，给你的滑动窗口大小 k 等于 3。我们使用大小为 3 的滑动窗口，来找到这个最大值序列。
 *
 * * 第一个滑动窗口内的数字是 0, 4, 2，最大值为 4
 * * 移动窗口，窗口内数字变为 4, 2, 1，最大值仍然为 4
 * * 继续移动窗口，窗口内数字变为 2, 1, 0，最大值变为 2
 * * 接着移动窗口，窗口内数字变为 1, 0, 8，最大值变为 8
 * * 继续移动窗口，最后窗口内的数字变为 0, 8, 2，最大值仍然是 8
 *
 * 这时滑动窗口再移动的话，窗口内的数字就不足 k 个，于是结束处理过程。最后就得到了最大值数组 4, 4, 2, 8, 8。
 * </pre>
 */
object P093SlidingWindow {
  // Time: O(k*n), Space: O(1)
  def maxNumInSlidingWindowBruteForce(nums: collection.IndexedSeq[Int], k: Int): Array[Int] = {
    require(nums != null && nums.nonEmpty)
    val result = Array.ofDim[Int](nums.length - k + 1)
    for (left <- 0 to nums.length - k) {
      result(left) = (left until left + k).foldLeft(nums(left))((max, i) => math.max(max, nums(i)))
    }
    result
  }

  // Time: O(n*log(k)), Space: O(k)
  def maxNumInSlidingWindowTreeMap(nums: collection.IndexedSeq[Int], k: Int): Array[Int] = {
    require(nums != null && nums.nonEmpty)
    val result = Array.ofDim[Int](nums.length - k + 1)
    val tree = mutable.TreeMap[Int, Int]() ++ (0 until k).map(i => nums(i) -> i)
    result(0) = tree.lastKey
    for (i <- k until nums.length) {
      if (tree(nums(i - k)) == i - k) tree.remove(nums(i - k))

      tree.put(nums(i), i)
      result(i - k + 1) = tree.lastKey
    }
    result
  }

  // Time: O(n), Space: O(n)
  def maxNumInSlidingWindowOn(nums: collection.IndexedSeq[Int], k: Int): Array[Int] = {
    require(nums != null && nums.nonEmpty)
    val N = nums.length
    val result = Array.ofDim[Int](nums.length - k + 1)
    val maxFromLeft = Array.ofDim[Int](N)
    val maxFromRight = Array.ofDim[Int](N)
    maxFromLeft(0) = nums(0)
    maxFromRight(N - 1) = nums(N - 1)
    var i = 1
    var j = N - 2
    while (i < N) {
      maxFromLeft(i) = if (i % k == 0) nums(i) else math.max(nums(i), maxFromLeft(i - 1))
      maxFromRight(j) = if (j % k == k - 1) nums(j) else math.max(nums(j), maxFromRight(j + 1))

      i += 1
      j -= 1
    }
    for (n <- 0 to N - k) {
      result(n) = math.max(maxFromRight(n), maxFromLeft(n + k - 1))
    }
    result
  }
}
