package basic

/**
 * P20. 求两个有序数组的中位数
 * https://algocasts.io/series/algo-problems-1-50/episodes/Qqpn6pkK
 * 这个题目说的是，给你两个排好序的整数数组 nums1 和 nums2，假设数组是以递增排序的，数组的大小分别是 m 和 n。你要找到这两个数组的中位数。要求算法的时间复杂度是 O(log(m+n))。
 *
 * 这里两个数组中位数的意思是，两个数组合到一起排序后，位于中间的那个数，如果一共有偶数个，则是位于中间的两个数的平均数。
 * <pre>
 * 比如说，给你的两个数组是：
 *
 * 1, 3
 * 2
 *
 * 它们放在一起排序后是：
 *
 * 1, 2, 3
 *
 * 所以中位数就是 2。
 *
 * 再比如说，给你的两个数组是：
 *
 * 1, 3
 * 2, 4
 *
 * 它们放在一起排序后是：
 *
 * 1, 2, 3, 4
 *
 * 所以中位数就是 (2 + 3) / 2 = 2.5。
 * </pre>
 */
object P020FindMedianNumber {
  def findMedianSortedSeq(
      orderly1: scala.collection.IndexedSeq[Int],
      orderly2: scala.collection.IndexedSeq[Int]): Double = {
    val total = orderly1.size + orderly2.size
    if ((total & 1) == 1) {
      findKthSmallestInSortedSeq(orderly1, orderly2, total / 2 + 1).toDouble
    } else {
      val a = findKthSmallestInSortedSeq(orderly1, orderly2, total / 2).toDouble
      val b = findKthSmallestInSortedSeq(orderly1, orderly2, total / 2 + 1).toDouble
      (a + b) / 2
    }
  }

  private def findKthSmallestInSortedSeq(
      nums1: scala.collection.IndexedSeq[Int],
      nums2: scala.collection.IndexedSeq[Int],
      _k: Int): Int = {
    var k = _k
    var len1 = nums1.length
    var len2 = nums2.length
    var base1 = 0
    var base2 = 0
    while (true) {
      if (len1 == 0) return nums2(base2 + k - 1)
      else if (len2 == 0) return nums1(base1 + k - 1)
      else if (k == 1) return Math.min(nums1(base1), nums2(base2))

      val i = Math.min(k / 2, len1)
      val j = Math.min(k - i, len2)
      val a = nums1(base1 + i - 1)
      val b = nums2(base2 + j - 1)

      if (i + j == k && a == b) return a

      println(s"k:$k, len1:$len1, len2:$len2, base1:$base1, base2:$base2, i:$i, j:$j, a:$a, b:$b")

      if (a <= b) {
        base1 += i
        len1 -= i
        k -= i
      }
      if (a >= b) {
        base2 += j
        len2 -= j
        k -= j
      }
    }
    throw new RuntimeException()
  }
}
