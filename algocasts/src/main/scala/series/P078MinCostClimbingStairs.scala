package series

/**
 * P78. 爬楼梯的最小代价
 * https://algocasts.io/series/algo-problems-51-100/episodes/q6G7qZW0
 * 这个题目说的是，给你一个整数数组，数组中的整数表示爬对应阶楼梯的代价。你可以从第 0 阶或第 1 阶楼梯开始爬，每次可以向上爬 1 阶或 2 阶。
 * 那么请问，爬完这个楼梯的最小代价是多少？
 * <pre>
 * 比如说，给你的代价数组 c 是：
 *
 * 1, 2, 4, 2
 *
 * 爬完这个楼梯的最小代价为 4，也就是从第 1 阶（对应的代价为 2）开始，然后爬两阶就爬完了，代价是 2 + 2 = 4。
 * </pre>
 */
object P078MinCostClimbingStairs {
  // Time: O(n), Space: O(n)
  def minCostClimbingStairs(cost: IndexedSeq[Int]): Int = {
    if (cost == null || cost.isEmpty) return 0
    if (cost.length == 1) return cost.head
    val n = cost.length
    val d = Array.ofDim[Int](n)
    d(0) = cost(0)
    d(1) = cost(1)
    for (i <- 2 until n) {
      d(i) = math.min(d(i - 2), d(i - 1)) + cost(i)
    }

    println(java.util.Arrays.toString(d))
    math.min(d(n - 2), d(n - 1))
  }

  // Time: O(n), Space: O(1)
  def minCostClimbingStairsO1(cost: IndexedSeq[Int]): Int = {
    if (cost == null || cost.isEmpty) return 0
    if (cost.length == 1) return cost.head
    var first = cost(0)
    var second = cost(1)
    for (i <- 2 until cost.length) {
      val cur = math.min(first, second) + cost(i)
      first = second
      second = cur
    }
    math.min(first, second)
  }
}
