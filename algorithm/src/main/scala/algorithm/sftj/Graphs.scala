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

import com.typesafe.scalalogging.StrictLogging

import scala.collection.mutable

object Graphs extends StrictLogging {
  /**
   * 广度优先搜索（非加权图中查找最短路径）
   * http://www.ituring.com.cn/book/1864  6.4节
   * @param graph 图（有向图）
   * @param start 起始节点
   * @param comparison 比较函数
   * @return 广度搜索 graph，每个节点调用 comparison 函数。comparison 函数节点为true时返回 Some(node)，否则返回 None
   */
  def breadthFirstSearch[T](graph: Map[T, Seq[T]], start: T, comparison: T => Boolean): Option[T] = {
    val firstSearchs = graph.getOrElse(start, Vector.empty)
    val searchQueue = mutable.Queue[T](firstSearchs: _*)
    val searched = mutable.Set[T](firstSearchs: _*)

    var count = 0
    while (searchQueue.nonEmpty) {
      count += 1
      val person = searchQueue.dequeue()
      if (comparison(person)) {
        logger.debug(s"[$count] 找到数据 $person $searchQueue")
        return Some(person)
      } else {
        // 已检测过的节点不再加入搜索队列
        val pendings = graph
          .getOrElse(person, Vector.empty)
          .flatMap(pending =>
            if (searched(pending)) {
              None
            } else {
              searched += pending
              Some(pending)
            })

        searchQueue.enqueueAll(pendings)
        logger.debug(s"[$count] $person $searchQueue")
      }
    }

    None
  }

  /**
   * 狄克斯特拉查找算法（加权图中查找最短路径）
   * http://www.ituring.com.cn/book/1864  7.5节
   * @param graph 加权图
   * @param start 起始节点
   * @param end 终点节点
   * @return (最短路径的加权总值，最短路径)
   */
  def dijkstraSearch[T](graph: Map[T, Map[T, Int]], start: T, end: T): (Int, List[T]) = {
    val processed = mutable.Set.empty[T]

    val startNeighbors = graph(start)

    // start 节点到任一节点最短花费
    val costs = mutable.Map.empty[T, Int] ++
      startNeighbors ++
      graph.keysIterator
        .filterNot(node => node == start || startNeighbors.contains(node))
        .map(node => node -> Int.MaxValue)

    // 最短花费的父节点映射
    val parents = mutable.Map.empty[T, Option[T]] ++ graph(start).keys.map(key => (key, Some(start)))

    /**
     * 从未处理节点中找到开销最小的节点
     * @param costs 未处理节点
     * @return 找到返回Some[T]，否则返回None
     */
    def findLowestCostNode(costs: scala.collection.Map[T, Int]): Option[T] = {
      var lowestCost = Int.MaxValue
      var lowestCostNode = Option.empty[T]
      for ((node, cost) <- costs if cost < lowestCost && !processed(node)) {
        lowestCost = cost
        lowestCostNode = Some(node)
      }
      lowestCostNode
    }

//    var count = 0
    var maybeNode = findLowestCostNode(costs)
    while (maybeNode.nonEmpty) {
      val node = maybeNode.get
      val cost = costs(node)
      val neighbors = graph(node)
      for (n <- neighbors.keysIterator) {
        val newCost = cost + neighbors(n)
        if (costs(n) > newCost) {
          costs(n) = newCost
          parents(n) = Some(node)
        }
      }
      processed += node
      maybeNode = findLowestCostNode(costs)
    }

    logger.debug(s"costs: $costs, parents: $parents")

    var paths = List(end)
    var path = parents.get(end).flatten
    while (path.nonEmpty) {
      paths ::= path.get
      path = parents.get(path.get).flatten
    }
    (costs(end), paths)
  }
}
