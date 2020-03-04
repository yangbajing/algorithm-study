package org.gs.sort

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag
import scala.util.Random

/** Quicksort
 *
 * @constructor creates a new QuickX
 * @tparam A elements are generic and ordered ClassTag preserves Array type at runtime
 * @param ord implicitly provides ordering
 * @see [[https://algs4.cs.princeton.edu/23quicksort/QuickX.java.html]]
 * @author Scala translation by Gary Struthers from Java by Robert Sedgewick and Kevin Wayne.
 */
class QuickX[A: ClassTag](implicit ord: A => Ordered[A]) {
  private def shuffleArrayBuffer[A: ClassTag](xs: Array[A]): Array[A] = {
    val a = Random.shuffle(xs.toBuffer)
    a.toArray
  }

  /** exchange i and j in array */
  def exchange(i: Int, j: Int, xs: Array[A]) {
    val iVal = xs(j)
    val jVal = xs(i)
    xs.update(i, iVal)
    xs.update(j, jVal)
  }

  /** Insertion sort is faster when partition or array has fewer than 10 elements
   * Exchange 2 elements when the one on the left is greater than the one on the right
   *
   * @param generic array to sort
   */
  def insertionSort(xs: Array[A]): Unit = {
    var i = 1

    @tailrec
    def loopI(): Unit = {
      var j = i

      @tailrec
      def loopJ(): Unit = {
        // if (right > left)
        if (xs(j) >= xs(j - 1)) j = 0
        else {
          exchange(j, j - 1, xs)
          j -= 1
        }
        if (j > 0) loopJ()
      }

      i += 1
      loopJ()
      if (i < xs.length) loopI()
    }

    loopI()
  }

  // QuickSort 实现
  private def partition(lo: Int, hi: Int, xs: Array[A]): Int = {
    def medianOf3(xs: Array[A]): Int = { //@TODO
      val center = (lo + hi) / 2
      if (xs(lo) > xs(center)) exchange(lo, center, xs)
      if (xs(lo) > xs(hi)) exchange(lo, hi, xs)
      if (xs(center) > xs(hi)) exchange(center, hi, xs)
      exchange(center, hi - 1, xs)
      hi - 1
    }

    /** Scan from left of array until finding element greater than partition
     *
     * stop incrementing when x >= lo
     *
     * @param i partition
     * @param xs array
     * @return new i index
     */
    def scanLR(i: Int, xs: Array[A]): Int = {
      def stopInc(x: A): Boolean = x >= xs(lo)

      def from(): Int = if (lo < i) i else lo + 1

      xs.indexWhere(stopInc, from())
    }

    /** Scan from right of array until finding element lesser than partition
     *
     * stop decrementing when x <= lo
     *
     * @param i partition
     * @param xs array
     * @return new j index
     */
    def scanRL(j: Int, xs: Array[A]): Int = {
      def stopDec(x: A) = x <= xs(lo)

      xs.lastIndexWhere(stopDec, j)
    }

    @tailrec /** scan both partition, put i, j in order, loop */
    def loop(i: Int, j: Int, xs: Array[A]): Int = {
      val rLessLoIdx = scanRL(j, xs)
      scanLR(i, xs) match {
        case lGreatLoIdx if lGreatLoIdx == rLessLoIdx =>
          // 两边都有序，索引值刚好
          rLessLoIdx
        case lGreatLoIdx if lGreatLoIdx > rLessLoIdx =>
          // 右边都大于 lo, 交换 lo 与 rLessLoIdx
          // 5 4 2 3 9 7 8 6
          // lo    r l
          // 3 4 2 5 9 7 8 6
          //       lo
          exchange(lo, rLessLoIdx, xs)
          rLessLoIdx
        case lGreatLoIdx =>
          // 从左边开始第一个大于切分元素，从右边开始第一个小于切分元素，交换两者
          exchange(lGreatLoIdx, rLessLoIdx, xs)
          loop(lGreatLoIdx, rLessLoIdx - 1 /* rLessLoIdx */, xs)
      }
    }
    loop(lo + 1, hi, xs)
  }

  private def sort(low: Int, high: Int, xs: Array[A]): Unit = if (low < high) {
//    if ((low + 10) > high) insertionSort(xs)
//    else {
    val j = partition(low, high, xs)
    sort(low, j - 1, xs)
    sort(j + 1, high, xs)
//    }
  }

  /** Quicksort recursively partition and sort partions
   *
   * @param a generic array
   * @param shuffle optionally shuffle for performance
   * @return sorted array
   */
  def sort(a: Array[A], shuffle: Boolean = true): Array[A] = {
    val myArray = if (shuffle) shuffleArrayBuffer(a) else a

    sort(0, myArray.length - 1, myArray)
    myArray
  }
}
