package series

import basic.P018MergeOrderlyArray

import scala.collection.mutable

/**
 * P90. 合并 K 个有序链表
 * https://algocasts.io/series/algo-problems-51-100/episodes/RVmVkkGQ
 * 这个题目说的是，给你 K 个递增排序的单链表，你要把它们合成一个链表，并且保持递增排序。
 * 合成链表的节点直接使用 K 个链表中的节点即可，无需创建新节点。
 * <pre>
 * 比如说，给你以下 3 个有序链表：
 *
 * 1 -> 2 -> 4
 * 1 -> 4 -> 8
 * 0 -> 2
 *
 * 合并后的有序链表是：
 *
 * 0 -> 1 -> 1 -> 2 -> 2 -> 4 -> 4 -> 8
 * </pre>
 */
object P090MergeSortedLists {
  // Time: O(n*log(k)), Space: O(log(k))
  def mergeWithDivideConquer[T](lists: IndexedSeq[ListNode[T]])(implicit ev1: Ordering[T]): ListNode[T] = {
    require(lists != null && lists.nonEmpty)

    def merge(start: Int, end: Int): ListNode[T] =
      if (start == end) lists(start)
      else if (start > end) null
      else {
        val mid = start + (end - start) / 2
        val left = merge(start, mid)
        val right = merge(mid + 1, end)
        P018MergeOrderlyArray.mergeList(left, right)
      }

    merge(0, lists.size - 1)
  }

  // Time: O(n*log(k)), Space: O(k)
  def mergeWithMinHeap[T](lists: ListNode[T]*)(implicit ev1: Ordering[T]): ListNode[T] = {
    require(lists != null && lists.nonEmpty)

    val heap = mutable.PriorityQueue[ListNode[T]]()((x, y) => ev1.reverse.compare(x.value, y.value))
    lists.foreach(list => heap.addOne(list))
    val dummy = ListNode(null.asInstanceOf[T])
    var p = dummy
    while (heap.nonEmpty) {
      val node = heap.dequeue()
      if (node.next != null) heap.addOne(node.next)

      p.next = node
      p = p.next
    }

    dummy.next
  }

  // Time: O(k*n), Space: O(1)
  def mergeWithOneByOne[T](lists: ListNode[T]*)(implicit ev1: Ordering[T]): ListNode[T] = {
    require(lists != null && lists.nonEmpty)

    lists.reduce((x, y) => P018MergeOrderlyArray.mergeList(x, y))
  }
}
