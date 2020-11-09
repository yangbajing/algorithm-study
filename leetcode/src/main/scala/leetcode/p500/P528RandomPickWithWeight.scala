package leetcode.p500

import scala.annotation.tailrec
import scala.util.Random

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @date 2020-10-23 11:33:19
 */
class P528RandomPickWithWeight(_w: Array[Int]) {
  private val w = _w.clone()
  for (i <- 1 until w.length) w(i) += w(i - 1)

  def pickIndex(): Int = {
    val r = Random.nextInt(w.last) + 1

    binarySearch(r, 0, w.length - 1)
  }

  @tailrec
  final def binarySearch(r: Int, low: Int, high: Int): Int = {
    if (low < high) {
      val mid = low + (high - low) / 2
      val v = w(mid)
      if (v == r) mid
      else if (v > r) binarySearch(r, low, mid)
      else binarySearch(r, mid + 1, high)
    } else {
      low
    }
  }

  def pickIndexIterable(): Int = {
    val r = Random.nextInt(w.last)
    var low = 0
    var high = w.length - 1
    while (low != high) {
      val mid = low + (high - low) / 2
      if (r >= w(mid)) low = mid + 1
      else high = mid
    }
    low
  }
}
