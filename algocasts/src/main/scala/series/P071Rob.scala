package series

/**
 * P71. 抢劫连排房子
 * https://algocasts.io/series/algo-problems-51-100/episodes/q2m5D2Wz
 * 这个题目说的是，有一个强盗要去抢一排连排房子，每个房子里放着正整数金额的钱，可以用一个整数数组来表示。
 * 这个强盗唯一的限制就是不能同时抢相邻的两个房子，那么请问，这个强盗最多可以抢到多少钱。
 * <pre>
 * 比如说，这排房子里放着的钱是整数数组 nums：
 *
 * 8, 1, 2, 9, 6
 *
 * 在不能抢相邻房子的情况下，最多可以抢到的钱是 17，就是抢 8 和 9 这两个数字对应的房子。
 *
 * 抢完 8 和 9 后，其它的房子就都不能抢了，因为都与这两所房子相邻。
 *
 * 而其它的抢劫组合也都没有 17 大，比如抢 8,2,6，这三个房子不相邻可以同时抢，但抢它们的话能抢到的钱只有 16，没有 17 大。
 * </pre>
 */
object P071Rob {
  // Time: O(n), Space: O(1)
  def robO1[T](nums: Iterable[T])(implicit ev1: Numeric[T]): T = {
    require(nums != null && nums.nonEmpty)
    var prevPrev = ev1.zero
    var prev = ev1.zero
    for (n <- nums) {
      // prev = [0, i-1]
      // prevPrev + n = [p, i-2] + n
      val cur = ev1.max(prev, ev1.plus(prevPrev, n))
      prevPrev = prev
      prev = cur
    }
    prev
  }
}
