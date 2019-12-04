package basic

import org.scalatest.{ FunSuite, Matchers }

class P046MaxProfitBruteForceTest extends FunSuite with Matchers {
  import P046MaxProfitBruteForce._
  test("testMaxProfitBruteForce") {
    maxProfitBruteForce(List(9, 3, 7, 5, 1, 8)) should be(7)
    maxProfitBruteForce(List(9, 8, 7, 6)) should be(0)
    maxProfitBruteForce(List(9, 3, 8, 5, 1, 3)) should be(5)
  }
}
