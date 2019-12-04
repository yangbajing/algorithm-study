package basic

import org.scalatest.{ FunSuite, Matchers }

class P045ValidBracketsTest extends FunSuite with Matchers {
  import P045ValidBrackets._
  test("testIsValidBrackets") {
    isValidBrackets("([]){}") shouldBe true
    isValidBrackets("([{}])") shouldBe true
    isValidBrackets("([]{)}") shouldBe false
    isValidBrackets("([]") shouldBe false
    isValidBrackets("([])}") shouldBe false
  }
}
