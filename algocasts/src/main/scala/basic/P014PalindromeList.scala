package basic

import study.CollectionUtils

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
