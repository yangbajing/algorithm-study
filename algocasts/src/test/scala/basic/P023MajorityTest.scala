package basic

import org.scalatest.{ FunSuite, Matchers }

class P023MajorityTest extends FunSuite with Matchers {
  import P023Majority._
  test("testGetMajority") {
    getMajority(List(3, 1, 3, 1, 1, 1, 3)) should ===(1)
    getMajority(Vector(1, 3, 3, 1, 3, 1)) should ===(3)
    getMajority(Array(3, 3, 1, 3, 1, 1, 3)) should ===(3)
    getMajority(Seq(2)) should ===(2)
  }
}
