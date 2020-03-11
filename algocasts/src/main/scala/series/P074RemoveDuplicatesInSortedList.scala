package series

/**
 * P74. 有序链表删除重复节点
 * https://algocasts.io/series/algo-problems-51-100/episodes/D1mR9jWz
 * 这个题目说的是，给你一个单链表，这个单链表节点上的数字是有序的。对于出现多次的数字，你要把它们全删掉，留下只出现一次的节点，
 * 最后返回处理后的单链表。
 * <pre>
 * 比如说，给你的有序单链表是：
 *
 * 1 -> 1 -> 2 -> 4
 *
 * 1 出现了多次，删掉它后，你要返回的链表是：
 *
 * 2 -> 4
 * </pre>
 */
object P074RemoveDuplicatesInSortedList {
  def removeDuplicatesInSortedList[T](list: ListNode[T]): ListNode[T] = {
    if (list == null) return list

    // dummy 1 -> 1 -> 2 -> 4
    // p     q
    // p          q
    //                 q and p.next

    val dummy = ListNode(null.asInstanceOf[T], list)
    var prev = dummy
    var cur = prev.next
    while (cur != null) {
      while (cur.next != null && cur.value == cur.next.value) cur = cur.next

      if (prev.next != cur) prev.next = cur.next
      else prev = prev.next
      cur = prev.next
    }
    dummy.next
  }
}
