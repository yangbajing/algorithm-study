package algo

import basic.P029AlgoCasts
import org.scalatest.{ FunSuite, Matchers }

import scala.jdk.CollectionConverters._

class P029AlgoCastsTest extends FunSuite with Matchers {
  private val casts = new P029AlgoCasts()

  test("testGenerateParentheses") {
    val list = casts.generateParentheses(3).asScala
    list.foreach(println)
    list should ===(List("((()))", "(()())", "(())()", "()(())", "()()()"))
  }

  test("testGenerateParenthesesDP") {
    casts.generateParenthesesDP(3).forEach(println)
  }
}
