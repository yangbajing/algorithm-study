package basic

/**
 * P49. 二进制中 1 的个数
 * https://algocasts.io/series/algo-problems-1-50/episodes/XZWvbBW7
 * 这个题目说的是，给你一个整数，你要计算它的二进制表示中 1 的个数，然后返回。
 * <pre>
 * 比如说，给你的整数是 12，它的二进制表示是：
 *
 * 1100
 *
 * 包含两个 1，因此你要返回 2。
 * </pre>
 */
object P049NumberOfOneWithMask {
  // Time: O(m), Space: O(1)
  def numberOfOneWithMask(n: Int): Int = {
    var mask = 1
    var count = 0
    while (mask != 0) {
      if ((n & mask) != 0) count += 1
      mask <<= 1
    }
    count
  }

  // Time: O(k), Space: O(1)
  def numberOfOne(n: Int): Int = {
    var count = 0
    var mask = n
    while (mask != 0) {
      count += 1
      println(s"mask: $mask, count: $count")
      mask &= mask - 1
    }
    count
  }
}
