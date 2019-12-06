package series

import scala.collection.mutable

/**
 * P57. 数据流中第 K 大的元素
 * https://algocasts.io/series/algo-problems-51-100/episodes/zbmK2MWZ
 * 这个题目说的是，你要实现一个类，用来求数据流中第 K 大的元素。你需要实现这个类中的两个函数。
 * 第一个是构造函数，它接收一个整数数组以及一个整数 K，整数数组作为初始数据流。第二个是 add 函数，
 * 接收一个整数表示新流入的数据，然后返回当前第 K 大的元素。
 * <pre>
 * 比如说，给你的 K 是 3，初始的数组是：
 *
 * 1, 5, 2, 8
 *
 * 这时假如调用 add 函数增加一个数字 9，数据流变成：
 *
 * 1, 5, 2, 8, 9
 *
 * 你要返回第 3 大的元素是 5。
 *
 * 假如再调用 add 函数增加一个数字 0，数据流变成：
 *
 * 1, 5, 2, 8, 9, 0
 *
 * 这时你要返回的第 3 大元素仍然是 5。
 * </pre>
 */
object P057KthLargestElement {
  class KthLargestElement[T](init: Iterable[T], k: Int)(implicit ord: Ordering[T]) {
    private val queue = new java.util.PriorityQueue[T]()

    init.foreach(add)

    def add(v: T): KthLargestElement[T] = {
      if (queue.size < k) {
        queue.add(v)
      } else if (ord.gt(v, queue.peek())) {
        queue.poll()
        queue.add(v)
      }
      this
    }
    def max: Option[T] = if (queue.size < k) None else Some(queue.peek())
  }
}
