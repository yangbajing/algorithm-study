package basic

import scala.collection.mutable

object P029AlgoCasts {
  private def generate(result: mutable.Buffer[String], str: String, left: Int, right: Int): Unit = {
    println(s"$str, $left, $right, $result")
    if (left == 0 && right == 0) {
      result.addOne(str)
    } else {
      if (left > 0) generate(result, str + '(', left - 1, right)
      if (right > left) generate(result, str + ')', left, right - 1)
    }
  }

  // Time: O(4^n / sqrt(n)), Space: O(n)
  def generateParentheses(n: Int): List[String] = {
    if (n <= 0) Nil
    else {
      val result = mutable.Buffer.empty[String]
      generate(result, "", n, n)
      result.toList
    }
  }
}
