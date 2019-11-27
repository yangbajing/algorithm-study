package basic

import java.util.Objects

/**
 * P17. 带有 min 函数的栈
 * https://algocasts.io/series/algo-problems-1-50/episodes/LPmwNWqw
 * 这个题目说的是，你要实现一个栈，除了提供 push，pop，top 等常用函数，还需要提供一个函数在 O(1) 时间内取得这个栈里的最小元素。
 */
object P017MergeOrderlyList {
  case class ListNode(value: Int, var next: ListNode = null)

  def mergeOrderly(l1: ListNode, l2: ListNode): ListNode = {
    var p = ListNode(0)
    var x = l1
    var y = l2
    val dummy = p

    while (Objects.nonNull(x) && Objects.nonNull(y)) {
      if (x.value < y.value) {
        p.next = x
        x = x.next
      } else {
        p.next = y
        y = y.next
      }
      p = p.next
    }
    if (Objects.nonNull(x)) {
      p.next = x
    } else if (Objects.nonNull(y)) {
      p.next = y
    }

    dummy.next
  }
}
