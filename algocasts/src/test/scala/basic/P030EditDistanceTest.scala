package basic

import org.scalatest.{ FunSuite, Matchers }

class P030EditDistanceTest extends FunSuite with Matchers {
  import P030EditDistance._
  test("editDistance") {
    editDistance("car", "ba") should ===(2)
  }
  test("editDistance1dArray") {
    editDistance1dArray("car", "ba") should ===(2)
  }
}
