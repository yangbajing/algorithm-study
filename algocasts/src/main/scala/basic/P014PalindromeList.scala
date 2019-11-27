package basic

import study.CollectionUtils

/**
 * P14. 判断单链表是否为回文链表
 * https://algocasts.io/series/algo-problems-1-50/episodes/VXGOqWQd
 * 这个题目说的是，给你一个单链表表示的数，你要判断它是不是一个回文数字。回文数字就是正着读和反着读都相同的数字。
 * <pre>
 * 比如说，给你的链表是：
 *
 * 4 -> 2
 *
 * 它表示 42，反过来是 24，不是一个回文数字，因此你要返回 false。
 *
 * 再比如说，给你的链表是：
 *
 * 4 -> 2 -> 2 -> 4
 *
 * 它表示 4224，反过来也是 4224，它是一个回文数字，因此你要返回 true。
 * </pre>
 */
object P014PalindromeList {
  def isPalindromeList[T](list: Iterable[T]): Boolean = {
    val len = list.size

    val (half, half2) = list.splitAt(len / 2)
    val reverseHalfList = CollectionUtils.reverse(if (len % 2 == 1) half2.drop(1) else half2)
    half == reverseHalfList
  }

  def main(args: Array[String]): Unit = {
    println(isPalindromeList(Vector(1, 2, 3, 2, 1)))
    println(isPalindromeList(List(1, 2, 3, 3, 2, 1)))
    println(isPalindromeList(Vector(1, 2, 3, 4, 2, 1)))
    println(isPalindromeList(List(1, 2, 3, 3, 3, 2, 1)))
    println(isPalindromeList(List(1, 2, 3, 3, 3, 2, 1, 0)))
  }
}
