package basic

import org.scalatest.{ FunSuite, Matchers }

class P041UglyNumberTest extends FunSuite with Matchers {
  import P041UglyNumber._
  test("testIsUglyNumber") {
    isUglyNumber(45) should be(true)
    isUglyNumber(42) should be(false)
  }
}
