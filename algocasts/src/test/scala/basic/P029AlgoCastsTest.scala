package basic

import org.scalatest.{ FunSuite, Matchers }

class P029AlgoCastsTest extends FunSuite with Matchers {
  import P029AlgoCasts._

  test("testGenerateParentheses") {
    generateParentheses(3) should ===(List("((()))", "(()())", "(())()", "()(())", "()()()"))
  }
}
