package basic

import org.scalatest.{ FunSuite, Matchers }

class P031GrooveCapacityTest extends FunSuite with Matchers {
  import P031GrooveCapacity._
  test("testMaxWater") {
    maxWater(Vector(1, 2, 3, 4, 5, 6)) should be(9)
    maxWater(Array(1, 2, 3, 4, 5, 6)) should be(9)
    maxWater(IndexedSeq(9, 4, 7, 3, 5)) should be(20)
  }
}
