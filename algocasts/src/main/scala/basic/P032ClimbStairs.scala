package basic

/**
 * P32. 爬楼梯方法数（fibonacci）
 *https://algocasts.io/series/algo-problems-1-50/episodes/Y9pJNpAb
 * 这个题目说的是，给你一个 n 阶的楼梯，每次你可以爬 1 阶或 2 阶，你要求出爬完这个楼梯有多少种不同的方法。
 * <pre>
 * 比如说，楼梯只有 1 阶，显然你只有一种爬法，就是爬 1 阶，然后到顶。
 *
 * 再比如说，楼梯有 2 阶，那么你可以用两次 1 阶爬到顶，也可以用一次 2 阶爬到顶。共 2 种爬法。
 * </pre>
 */
object P032ClimbStairs {
  def climbstairsRecursive(n: Int): Int = {
    if (n < 2) 1 else climbstairsRecursive(n - 1) + climbstairsRecursive(n - 2)
  }

  def climbstairsIterative(n: Int): Int = {
    var first = 1
    var second = 1
    for (i <- 1 until n) {
      val third = first + second
      first = second
      second = third
    }
    second
  }
}
