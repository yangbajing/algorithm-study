package basic

import org.scalatest.{ FunSuite, Matchers }

class P050SetZeroInMatrixTest extends FunSuite with Matchers {
  import P050SetZeroInMatrix._
  test("testSetZeroInMatrixO1-int") {
    val matrix = Array(Array(1, 2, 3), Array(4, 0, 6), Array(0, 8, 9))
    setZeroInMatrixO1(matrix)
    matrix should be(Array(Array(0, 0, 3), Array(0, 0, 0), Array(0, 0, 0)))
  }
  test("testSetZeroInMatrixO1-double") {
    val matrix: Array[Array[Double]] = Array(Array(1.1, 2.2, 3.3), Array(4.0, 0, 6.8), Array(0.0, 8.1, 9.9))
    val expected: Array[Array[Double]] = Array(Array(0, 0, 3.3), Array(0, 0, 0), Array(0, 0, 0))
    setZeroInMatrixO1(matrix)
    matrix should be(expected)
  }
}
