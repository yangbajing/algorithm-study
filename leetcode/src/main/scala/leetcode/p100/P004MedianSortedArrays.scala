package leetcode.p100

object P004MedianSortedArrays {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    var A = nums1
    var B = nums2
    if (A.length > B.length) { // keep A length < B length
      val tmp = A
      A = B
      B = tmp
    }
    val m = A.length
    val n = B.length

    var iMin = 0 // left i min
    var iMax = m // left i max
    val halfLen = (m + n + 1) / 2 // total half length

    while (iMin <= iMax) {
      val i = (iMin + iMax) / 2 // left index
      val j = halfLen - i // right

      if (i < iMax && A(i) < B(j - 1)) {
        iMin = i + 1 // i is too small
      } else if (i > iMin && A(i - 1) > B(j)) {
        iMax = i - 1 // i is too big
      } else { // i is perfect
        val maxLeft =
          if (i == 0) B(j - 1)
          else if (j == 0) A(i - 1)
          else math.max(A(i - 1), B(j - 1))
        if ((m + n) % 2 == 1) {
          return maxLeft
        }

        val minRight =
          if (i == m) B(j)
          else if (j == n) A(i)
          else math.min(B(j), A(i))
        return (maxLeft + minRight) / 2.0
      }
    }

    0.0
  }

  def findMedianSortedArrays2(nums1: Array[Int], nums2: Array[Int]): Double = {
    val nums =
      if (nums1.length == 0) nums2
      else if (nums2.length == 0) nums1
      else {
        val ints = Array.ofDim[Int](nums1.length + nums2.length)
        var i = 0
        var j = 0
        var n = 0
        while (n < ints.length) {
          val x = if (i < nums1.length) nums1(i) else Int.MaxValue
          val y = if (j < nums2.length) nums2(j) else Int.MaxValue
          if (x < y) {
            i += 1
            ints(n) = x
          } else {
            j += 1
            ints(n) = y
          }
          n += 1
        }
        ints
      }

    val mid = nums.length / 2
    println(s"mid: $mid, nums: ${nums.mkString(",")}")
    if (mid + mid == nums.length) (nums(mid) + nums(mid - 1)) / 2.0 else nums(mid)
  }
}
