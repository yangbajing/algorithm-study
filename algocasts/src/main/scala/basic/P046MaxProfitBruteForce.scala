package basic

/**
 * P46. 买卖股票的最大利润
 * https://algocasts.io/series/algo-problems-1-50/episodes/RVmV3kGQ
 * 这个题目说的是，给你一个整数数组，其中第 i 个元素表示的是第 i 天的股票价格，你要计算出先买一股，然后再卖出它能获得的最大利润。
 * <pre>
 * 比如说，给你的数组是：
 *
 * 9, 3, 7, 5, 1, 8
 *
 * 如果你在价格为 1 时买入并在价格为 8 时卖出，这时能获得最大的利润 7。
 *
 * 再比如说给你的数组是：
 *
 * 9, 8, 7, 6
 *
 * 这时股票每天都在迭，不存在买入再卖出来获利的可能，因此没有交易，最大利润为 0。
 * </pre>
 */
object P046MaxProfitBruteForce {
  def maxProfitBruteForce(prices: Iterable[Int]): Int = {
    if (prices == null || prices.size < 2) 0
    else {
      val iter = prices.iterator
      var max = 0
      var buy = iter.next()
      while (iter.hasNext) {
        val cur = iter.next()
        if (cur < buy) buy = cur
        else max = math.max(max, cur - buy)
      }
      max
    }
  }
}
