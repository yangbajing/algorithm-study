package series

import scala.collection.mutable
import scala.util.Random

/**
 * P58. 随机洗牌
 * https://algocasts.io/series/algo-problems-51-100/episodes/VXGOkqGQ
 * 这个题目说的是，给你一个整数数组表示一副牌，你要写一个随机洗牌函数来返回这个数组的一个排列。
 * 并且要保证每次返回的排列都是等概率的。假设已经给你一个完美的随机数生成器。
 */
object P058AlgoCasts {
  private val rnd = new Random

  def shuffle[T](arr: mutable.IndexedSeq[T]): Unit = {
    var i = arr.length - 1
    while (i > 0) {
      swap(arr, i, rnd.nextInt(i + 1))
      i -= 1
    }
  }
}
