package basic

import util.StringUtils

import scala.collection.mutable

/**
 * P45. 有效的括号序列
 * https://algocasts.io/series/algo-problems-1-50/episodes/4rpaqqpZ
 * 这个题目说的是，给你一个括号序列，里面包含小括号，中括号和大括号。你要判断这个括号序列是否有效。有效的括号序列要求，
 * 每个左括号都必须有一个同类的右括号与它正确配对。另外，空字符串认为是有效的括号序列。
 * <pre>
 * 比如说，给你的序列是：
 *
 * ()[]{}
 *
 * 小括号/中括号/大括号的左右括号都能正确配对，因此这是一个有效的括号序列。
 *
 * 再比如说给你的序列是：
 *
 * ([)]
 *
 * 这里面虽然正好有一对小括号和一对中括号，但它们的顺序不对，括号间无法正确配对，因此这不是一个有效的括号序列。
 * </pre>
 */
object P045ValidBrackets {
  val BRACKETS = Map('(' -> ')', '[' -> ']', '{' -> '}')

  // Time: O(n), Space: O(n)
  def isValidBrackets(str: String): Boolean = if (StringUtils.isBlank(str)) false else _isValidBrackets(str.trim)

  private def _isValidBrackets(trim: String): Boolean = {
    val stack = mutable.Stack[Char]()
    for (c <- trim) {
      BRACKETS.get(c) match {
        case Some(v) => stack.push(v)
        case None    => if (stack.isEmpty || stack.pop() != c) return false
      }
    }
    stack.isEmpty
  }
}
