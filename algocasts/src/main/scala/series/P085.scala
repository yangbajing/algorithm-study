package series

/**
 * P85. 最小硬币组合
 * https://algocasts.io/series/algo-problems-51-100/episodes/8eGx43GM
 * 这个题目说的是，给你一些面值不同的硬币，每一种面值的硬币都有无限多个，现在你要用这些硬币组成一个给定的数值，那么请问，最少需要多少个硬币。
 * 另外，如果给你的面值无法组成给定数值，就返回 -1。
 * <pre>
 * 比如说，给你的硬币有 1 分 2 分两种面值，现在你要用它们凑 4 分钱。
 *
 * 我们知道用 1 分 2 分凑 4 分有 3 种组合：
 *
 * 4 = 1 + 1 + 1 + 1
 * 4 = 1 + 1 + 2
 * 4 = 2 + 2
 *
 * 其中使用了最少硬币的组合是 2 + 2，用了两个硬币，于是要返回的答案就是 2。
 * </pre>
 */
object P085 {
  def minCoinCombination(coins: IndexedSeq[Int], sum: Int): Int = {
    val d = Array.ofDim[Int](sum + 1)
    (1 to sum).foreach(i => d(i) = Int.MaxValue)

    for {
      i <- 1 to coins.length
      j <- coins(i - 1) to sum // j 代表需要凑齐的费用
    } {
      val c = coins(i - 1)
      if (d(j - c) != Int.MaxValue) {
        d(j) = math.min(d(j), d(j - c) + 1)
      }
    }

    if (d(sum) == Int.MaxValue) -1 else d(sum)
  }
}
