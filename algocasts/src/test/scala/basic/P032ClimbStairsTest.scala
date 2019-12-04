package basic

import org.scalatest.{ FunSuite, Matchers }

class P032ClimbStairsTest extends FunSuite with Matchers {
  import P032ClimbStairs._

  test("testClimbstairsIterative") {
    climbstairsRecursive(3) should be(3)
  }

  test("testClimbstairsRecursive") {
    climbstairsIterative(5) should be(8)
  }

  test("test") {
    climbstairsRecursive(9) should be(climbstairsIterative(9))
    climbstairsRecursive(17) should be(climbstairsIterative(17))
    climbstairsRecursive(4) should be(climbstairsIterative(4))
  }
}
