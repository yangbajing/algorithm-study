package series

/**
 * P84. 硬币面值组合问题
 * https://algocasts.io/episodes/JNmDARGO
 * 这个题目说的是，给你一些面值不同的硬币，每一种面值的硬币都有无限多个，现在你要用这些硬币组成一个给定的数值，那么请问，
 * 总共有多少种可能的组合方式？
 * <pre>
 * 比如说，给你的硬币有 1 分 2 分两种面值，现在你要用它们凑 4 分钱，有以下 3 种组合方式：
 *
 * 4 = 1 + 1 + 1 + 1
 * 4 = 1 + 1 + 2
 * 4 = 2 + 2
 *
 * 因此，要返回的答案是 3。
 * </pre>
 */
object P084 {
  // Time: O(n^sum)
  def numberOfCoinCombinationRecursive(total: Int, coins: Array[Int]): Int = {
    // 从coins(0)开始累加到sum为止找到一个
    // 再从 sum - coins(0) 递减（递归返回），每次递减都将递减后的 sum 与 coins(1 to end) 相减，看是否 == 0
    def coinCombination(start: Int, sum: Int): Int = {
      //println(s"coinCombination($start, $sum)")
      if (sum == 0) return 1
      if (sum < 0) return 0
      var result = 0
      for (i <- start until coins.length) {
        //println(s"$sum - ${coins(i)}")
        result += coinCombination(i, sum - coins(i))
      }
      result
    }

    coinCombination(0, total)
  }

  // Time: O(n*sum), Space: O(n*sum)
  def numberOfCoinCombinationDP(sum: Int, coins: Array[Int]): Int = {
    val d = Array.ofDim[Int](coins.length + 1, sum + 1)
    (0 to coins.length).foreach(i => d(i)(0) = 1)
    for {
      i <- 1 to coins.length
      j <- 1 to sum
    } {
      val coin = coins(i - 1)
      val useCurCoin = if (j >= coin) d(i)(j - coin) else 0
      d(i)(j) = d(i - 1)(j) + useCurCoin // 上一行相同例币值是否可使用 + 当前币值可使用状态
      println(s"coin: $coin, useCurCoin: $useCurCoin; ($i, $j)")
      dump(d)
    }
    d(coins.length)(sum)
  }

  private def dump(d: Array[Array[Int]]): Unit = d.foreach { a =>
    println(java.util.Arrays.toString(a))
  }

  // Time: O(n*sum), Space: O(sum)
  def numberOfCoinCombinationDPOsum(sum: Int, coins: Array[Int]): Int = {
    val d = Array.ofDim[Int](sum + 1)
    d(0) = 1
    for {
      i <- 1 to coins.length
      j <- 1 to sum
    } {
      val coin = coins(i - 1)
      val useCurCoin = if (j >= coin) d(j - coin) else 0
      d(j) = d(j) + useCurCoin
    }
    d(sum)
  }
}
