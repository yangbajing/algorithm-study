package basic

import org.scalatest.{ FunSuite, Matchers }

class P038BinaryMatrixSearchTest extends FunSuite with Matchers {
  import P038BinaryMatrixSearch._
  test("testBinarySearch") {
    val matric = Vector(Vector(1, 3, 5), Vector(7, 9, 11))
    binarySearch(matric, 9) should be(Array(1, 1))
    binarySearch(matric, 2) should be(Array(-1, -1))
  }
}
