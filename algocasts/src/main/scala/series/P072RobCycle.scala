package series

/**
 * P72. 抢劫环形房子
 * https://algocasts.io/series/algo-problems-51-100/episodes/AwmXV9px
 * 这个题目说的是，有一个强盗要去抢一排两两相邻，并且首尾相接的环形房子，每个房子里放着正整数金额的钱，可以用一个整数数组来表示。
 * 这个强盗唯一的限制就是不能同时抢相邻的两个房子，那么请问，这个强盗最多可以抢到多少钱。
 * <pre>
 * 比如说，这排房子里放着的钱是整数数组 nums：
 *
 * 8, 1, 2, 9
 *
 * 这 4 个房子实际上围成了一个圆圈，也就是说 8 和 9 是相邻的，它们不能同时被抢。
 *
 * 在不能抢相邻房子的情况下，这里最多可以抢到的钱是 10，可以抢 8 和 2，也可以抢 1 和 9。
 * </pre>
 */
object P072RobCycle {
  // Time: O(n), Space: O(1)
  def robO1[T](nums: Iterable[T])(implicit ev1: Numeric[T]): T = {
    require(nums != null && nums.nonEmpty)

    def rob(iter: Iterator[T]): T = {
      var prevPrev = ev1.zero
      var prev = ev1.zero
      for (n <- iter) {
        val cur = ev1.max(prev, ev1.plus(prevPrev, n))
        prevPrev = prev
        prev = cur
      }
      prev
    }

    val x = rob(nums.iterator.drop(1))
    val y = rob(nums.iterator.slice(0, nums.size - 1))
    ev1.max(x, y)
  }
}
