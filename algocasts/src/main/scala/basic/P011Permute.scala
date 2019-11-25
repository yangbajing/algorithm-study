package basic

import java.util.Objects

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.immutable

/**
 * https://algocasts.io/series/algo-problems-1-50/episodes/ldGj7p9j
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
