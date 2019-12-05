package series

import org.scalatest.{ FunSuite, Matchers }

class P051MinSumOfPathTest extends FunSuite with Matchers {
  import P051MinSumOfPath._
  test("testMinSumOfPath") {
    val matrix = Vector(Vector(1, 2, 1), Vector(8, 4, 1), Vector(-8, 2, 1))
    minSumOfPath(matrix) should be(4)
  }
  test("testMinSumOfPath1dArray") {
    val matrix = Array(Array(1, 2, 1), Array(8, 4, 1), Array(-8, 2, 1))
    minSumOfPath1dIndex(matrix) should be(4)
  }
  test("tinSumOfPath1dIterative") {
    val matrix = Seq(IndexedSeq(1, 2, 1), List(8, 4, 1), Vector(-8, 2, 1))
    minSumOfPath1dIterative(matrix) should be(4)

    val matrix2: List[Seq[Double]] = List(IndexedSeq(1.2, 2.3, 1.2), Vector(8.9, 4.1, 1.2), Array(-8.2, 2.3, 1.5))
    minSumOfPath1dIterative(matrix2) should be(5.7)
  }
}
