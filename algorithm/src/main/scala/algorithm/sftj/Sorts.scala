/*
 * Copyright (c) 2018 Yang Jing
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package algorithm.sftj

import scala.collection.mutable

object Sorts {

  /**
   * 快速排序
   * http://www.ituring.com.cn/book/1864  4.2节
   * @param list 要排序的列表
   * @return 按升序排序列表
   */
  def genericQuicksort[T](list: IndexedSeq[T])(implicit ev1: T => Ordered[T]): Vector[T] = {
    if (list.size < 2) {
      list.toVector
    } else {
      val len = list.size
      val pivot = list(len / 2)
      val less = mutable.ArrayBuffer.empty[T]
      val greater = mutable.ArrayBuffer.empty[T]
      val pivots = mutable.ArrayBuffer.empty[T]
      for (item <- list) {
        if (item < pivot) less.append(item)
        else if (item > pivot) greater.append(item)
        else pivots.append(item)
      }
      genericQuicksort(less) ++ pivots ++ genericQuicksort(greater)
    }
  }

}
