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

object Greedys {
  /**
   * 贪婪算法（近似算法）
   * http://www.ituring.com.cn/book/1864  8.3节
   * @param stations 广播站与覆盖省份映射
   * @param states 需要
   * @return
   */
  def greedys[T](stations: Map[T, Set[T]], states: Set[T]): Set[T] = {
    val finalStations = mutable.Set.empty[T]
    var statesNeeded = Set.empty[T] ++ states

    while (statesNeeded.nonEmpty) {
      var bestStation = Option.empty[T]
      var statesCovered = Set.empty[T]
      for ((station, statesForStation) <- stations) {
        val covered = statesNeeded.intersect(statesForStation)
        if (covered.size > statesCovered.size) {
          bestStation = Some(station)
          statesCovered = covered
        }
      }

      statesNeeded --= statesCovered
      bestStation.foreach(station => finalStations += station)
    }

    finalStations.toSet
  }
}
