package basic

import org.scalatest.{ FunSuite, Matchers }

class P036BinarySearchTest extends FunSuite with Matchers {
  import P036BinarySearch._
  test("testBinarySearch") {
    binarySearch(Vector(-2, 0, 2, 4, 5, 8, 9), 5) should be(4)
    binarySearch(Array(-7, -6, -3, -1, 0, 3, 7, 9, 10, 13, 15), 3) should be(5)
  }
}
