package basic

import java.util.Objects

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.immutable

/**
 * P11. 数组的全排列
 * https://algocasts.io/series/algo-problems-1-50/episodes/ldGj7p9j
 * 这个题目说的是，给你一个整数数组，并且数组中没有重复元素，你要返回这个数组所有可能的排列。
 * <pre>
 * 比如说给你的数组是：
 *
 * 0, 1, 2
 *
 * 你要返回的所有排列是：
 *
 * 0, 1, 2
 * 0, 2, 1
 * 1, 0, 2
 * 1, 2, 0
 * 2, 0, 1
 * 2, 1, 0
 * </pre>
 */
object P011Permute {
  def swap[T](nums: Array[T], i: Int, j: Int): Unit = {
    val tmp = nums(i)
    nums(i) = nums(j)
    nums(j) = tmp
  }

  def swap[T](vecs: immutable.IndexedSeq[T], i: Int, j: Int): immutable.IndexedSeq[T] = {
    if (i == j) {
      vecs
    } else {
      val newJ = vecs(i)
      val newI = vecs(j)
      vecs.view.zipWithIndex.map {
        case (_, `i`) => newI
        case (_, `j`) => newJ
        case (v, _)   => v
      }.toVector
    }
  }

  def permuteRec[T](
      items: immutable.IndexedSeq[T],
      start: Int,
      result: mutable.Buffer[immutable.IndexedSeq[T]]): Unit = {
    if (start == items.length) {
      result.append(items)
      println(s"start: $start, $items")
    } else {
      var i = start
      while (i < items.length) {
        val swappedNums = swap(items, i, start)
        println(s"i: $i, start: $start, $swappedNums")
        permuteRec(swappedNums, start + 1, result)
        i += 1
      }
    }
  }

  // Time: O(n*n!), Space: O(n)
  def permute[T](vecs: immutable.IndexedSeq[T]): List[immutable.IndexedSeq[T]] = {
    if (Objects.isNull(vecs) || vecs.isEmpty) {
      Nil
    } else {
      val result = mutable.Buffer.empty[immutable.IndexedSeq[T]]
      permuteRec(vecs, 0, result)
      result.toList
    }
  }

  def main(args: Array[String]): Unit = {
    val results = permute(Vector("Y", "X", "J"))
    results.foreach(println)
  }
}
