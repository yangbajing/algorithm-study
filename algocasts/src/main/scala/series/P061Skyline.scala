package series

import scala.collection.mutable

/**
 * P61. 天际线
 * https://algocasts.io/series/algo-problems-51-100/episodes/LPmwqNpq
 * (left, right, high)
 *
 * 这个题目说的是，给你一组矩形表示的楼房，它们的底边在同一水平线上，并且楼房之间可以相邻，也可以重叠。你要找到这组楼房的轮廓线或者叫天际线，
 * 并返回这个轮廓线的关键点。
 */
object P061Skyline {
  final case class Rect(left: Int, right: Int, high: Int)

  // Time: O(n^2), Space: O(n)
  def skylinePointsMaxHeap(bindings: Vector[Rect]): Vector[(Int, Int)] = {
    var result: Vector[(Int, Int)] = Vector()
    val height: Vector[(Int, Int)] = bindings
      .flatMap { arr =>
        (arr.left, -arr.high) :: (arr.right, arr.high) :: Nil
      }
      .sortWith { case ((aX, aH), (bX, bH)) => if (aX == bX) aH < bH else aX < bX }

    var pq = mutable.PriorityQueue[Int](0) // Maximum in queue header.
    var preHeight = 0
    for ((x, h) <- height) {
      if (h < 0) pq.enqueue(-h)
      else pq = pq.filterNot(_ == h)

      if (pq.head != preHeight) {
        preHeight = pq.head
        result :+= x -> pq.head
      }
    }

    result
  }

  // Time: O(nlog(n)), Space: O(n)
  def skylinePointsTreeMap(bindings: Vector[Rect]): Vector[(Int, Int)] = {
    var result: Vector[(Int, Int)] = Vector()
    val height: Vector[(Int, Int)] = bindings
      .flatMap { arr =>
        (arr.left, -arr.high) :: (arr.right, arr.high) :: Nil
      }
      .sortWith { case ((aX, aH), (bX, bH)) => if (aX == bX) aH < bH else aX < bX }

    val tree = mutable.TreeMap[Int, Int](0 -> 1)
    var preHeight = 0
    for ((x, h) <- height) {
      if (h < 0) {
        tree.updateWith(-h) {
          case Some(n) => Some(n + 1)
          case None    => Some(1)
        }
      } else {
        tree.updateWith(h) {
          case Some(1) => None
          case Some(n) => Some(n - 1)
          case None    => None
        }
      }

      val max = tree.lastKey
      if (max != preHeight) {
        preHeight = max
        result :+= x -> max
      }
    }

    result
  }
}
