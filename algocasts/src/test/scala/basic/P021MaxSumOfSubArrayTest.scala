package basic

import org.scalatest.{ FunSuite, Matchers }

class P021MaxSumOfSubArrayTest extends FunSuite with Matchers {
  import P021MaxSumOfSubArray._

  test("testMaxSubOfSubArray") {
    maxSubOfSubArray(List(2, -8, 3, -2, 4, -10)) should ===(5)
    maxSubOfSubArray(List(2, -8, 3, -2, 4, 10)) should ===(15)
  }
}
