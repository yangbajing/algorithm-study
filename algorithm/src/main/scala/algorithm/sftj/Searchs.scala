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

import scala.annotation.tailrec

object Searchs {
  /**
   * 泛型二分查找
   * http://www.ituring.com.cn/book/1864  1.2节
   * @param list 待查找的列表
   * @param item 要查找的值
   * @param ev1 隐式函数（将元素转变成可比较的）
   * @return
   */
  def genericBinarySearch[T](list: IndexedSeq[T], item: T)(implicit ev1: T => Ordered[T]): Int = {
    @tailrec
    def _search(low: Int, high: Int): Int = {
      if (low > high) {
        -1
      } else {
        val mid = (low + high) / 2
        val guess = list(mid)
        //        println(s"low: $low, high: $high, mid: $mid, guess: $guess ? item: $item")
        if (guess > item) _search(low, mid - 1)
        else if (guess < item) _search(mid + 1, high)
        else mid
      }
    }

    if (list.isEmpty) -1
    else _search(0, list.size - 1)
  }
}
