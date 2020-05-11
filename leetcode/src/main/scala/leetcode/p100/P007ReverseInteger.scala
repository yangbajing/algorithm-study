package leetcode.p100

/**
 * [-2147483648, 2147483647]
 */
object P007ReverseInteger {
  def reverse(xx: Int): Int = {
    val maxValue = Int.MaxValue / 10
    val minValue = Int.MinValue / 10
    var rev = 0
    var x = xx

    while (x != 0) {
      val t = x % 10

      if (rev > maxValue || (rev == maxValue && t > 7)
          || rev < minValue || (rev == minValue && t < -8))
        return 0

      rev = rev * 10 + t
      x /= 10
    }

    rev
  }
}
