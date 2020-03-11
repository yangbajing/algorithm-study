package series

/**
 * P73. 有序链表去重
 * https://algocasts.io/series/algo-problems-51-100/episodes/KApAOjm6
 * 这个题目说的是，给你一个单链表，这个单链表节点上的数字是有序的。对于出现多次的数字，你要把重复的去掉，只保留一个即可。最后返回去重后的单链表。
 * <pre>
 * 比如说，给你的有序单链表是：
 *
 * 1 -> 1 -> 2 -> 2 -> 4
 * p    q
 * p         q
 *      p    q
 *           p    q
 *
 * 去重后，你要返回的链表是：
 *
 * 1 -> 2 -> 4
 * </pre>
 */
object P073DistinctInSortedList {
  // Time: O(n), Space: O(1)
  def distinctInSortedList[T](list: ListNode[T]): ListNode[T] = {
    require(list != null)
    val head = list
    var p = head
    var q = p.next
    while (q != null) {
      if (p.value == q.value) p.next = q.next
      else p = p.next
      q = q.next
    }
    head
  }
}
