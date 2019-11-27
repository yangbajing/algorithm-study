package basic

import java.util.Objects

/**
 * P28. 链表的相交节点
 * https://algocasts.io/series/algo-problems-1-50/episodes/AwmX9Gx6
 * 这个题目说的是，给你两个单链表，你要找到它们相交的第一个节点。如果两个链表没有相交，则返回空指针。
 * 假设链表无环，并且你不能改变它的原始结构。另外要求算法是线性时间复杂度，空间复杂度要求是 O(1)。
 * <pre>
 * 比如说，两条链表分别是：
 *
 * A:     1 -> 2
 *               \
 *                6 -> 7 -> null
 *               /
 * B: 3 -> 4 -> 5
 *
 * 你要返回的是 6 这个节点。
 * </pre>
 */
object P028IntersectionListNode {
  // Time: O(m+n), Space: O(1)
  def getIntersectionNode[T](headA: Iterable[T], headB: Iterable[T]): Option[T] = {
    if (Objects.isNull(headA) || headA.isEmpty || Objects.isNull(headB) || headB.isEmpty) None
    else headB.find(b => headA.exists(a => b == a))
  }
}
