package basic

/**
 * P40. 求两个单链表之和
 * https://algocasts.io/series/algo-problems-1-50/episodes/JNmDRpOZ
 * 这个题目说的是，给你两个非空的单链表，它们代表两个非负整数，并且逆序表示。你要将这两个数求和，
 * 并将结果以链表形式返回。你不需要考虑前导 0 这种情况，也就说 3 不会表示成 003 这样子。
 * <pre>
 * 比如说给你的两个链接表是：
 *
 * 1 -> 2 -> 3
 * 6 -> 7 -> 8 -> 9
 *
 * 1 -> 2 -> 3 表示的整数是 321，6 -> 7 -> 8 -> 9 表示的整数是 9876。我们需要输出的是它们求和后的链表：
 *
 * 7 -> 9 -> 1 -> 0 -> 1
 * </pre>
 */
object P040TowListSum {
  // Time: O(max(m, n)), Space: O(max(m, n))
  def twoListNumbersSum(list1: Iterable[Int], list2: Iterable[Int]): Seq[Int] = {
    var carry = 0 // 进位
    var result = List[Int]()
    val l1 = list1.iterator
    val l2 = list2.iterator
    while (l1.hasNext || l2.hasNext || carry != 0) {
      var sum = carry
      if (l1.hasNext) sum += l1.next()
      if (l2.hasNext) sum += l2.next()
      carry = sum / 10
      result ::= sum % 10
    }
    result.reverse
  }
}
