package basic

import org.scalatest.{ FunSuite, Matchers }

class P049NumberOfOneWithMaskTest extends FunSuite with Matchers {
  import P049NumberOfOneWithMask._
  test("testNumberOfOneWithMask") {
    numberOfOneWithMask(12) should be(2)
    numberOfOneWithMask(13) should be(3)
  }
  test("testNumberOfOne") {
    numberOfOne(12) should be(2)
    println("--------------------")
    numberOfOne(13) should be(3)
    println("--------------------")
    numberOfOne(14) should be(3)
    println("--------------------")
    numberOfOne(15) should be(4)
  }
}
