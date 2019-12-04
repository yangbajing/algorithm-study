package basic

import org.scalatest.{ FunSuite, Matchers }

class P043strstrTest extends FunSuite with Matchers {
  import P043strstr._
  test("testStrstr") {
    strstr("doctor strange", "master") should be(-1)
    strstr("doctor strange", "strange") should be(7)
  }
}
