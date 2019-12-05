package series

import org.scalatest.{ FunSuite, Matchers }

class P053ThreeNumSumToZeroTest extends FunSuite with Matchers {
  import P053ThreeNumSumToZero._
  test("testThreeNumSumToZero") {
    val result = threeNumSumToZero(Array(-1, 0, -1, 0, 1, 0, -4))
    result should ===(Seq(Seq(0, 0, 0), Seq(-1, 0, 1)))
  }
  test("testThreeNumSumToZero-double") {
    val result = threeNumSumToZero(Vector[Double](-1.2, 0, -1.2, 0, 1.2, 0, -4))
    result should ===(Seq(Seq(-1.2, 0, 1.2), Seq(0, 0, 0)))
  }
}
