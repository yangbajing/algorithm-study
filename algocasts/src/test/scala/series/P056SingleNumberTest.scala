package series

import org.scalatest.{ FunSuite, Matchers }

class P056SingleNumberTest extends FunSuite with Matchers {
  import P056SingleNumber._
  test("testSingleNumberXOR") {
    singleNumberXOR(List(1, 1, 2, 2, 4, 4, 6, 8, 8)) should be(6)
    singleNumberXOR(Array(1, 1, 2, 2, 3, 4, 4, 6, 6, 8, 8)) should be(3)
    singleNumberXOR(Array(1, 1, 2, 2, 3, 3, 4, 4, 6, 6, 8, 8)) should be(0)
    singleNumberXOR(Vector(1, 1, 2, 2, 4, 4, 5, 6, 6, 8, 8)) should be(5)
  }

  test("testSingleNumberSearch") {
    singleNumberSearch(IndexedSeq(1, 1, 2, 2, 4, 4, 6, 8, 8)) should be(Some(6))
    singleNumberSearch(Array(2, 3, 3, 4, 4, 6, 6, 8, 8)) should be(Some(3))
    singleNumberSearch(Vector(1, 1, 2, 2, 4, 4, 5, 6, 6, 8, 8)) should be(Some(5))
    singleNumberSearch(Vector(1, 1, 2, 2, 4, 4, 5, 5, 6, 6, 8, 8)) should be(None)
  }
}
