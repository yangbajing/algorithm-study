package basic

import org.scalatest.{ FunSuite, Matchers }

class P020FindMedianNumberTest extends FunSuite with Matchers {
  import P020FindMedianNumber._

  test("testFindMedianSortedSeq") {
    // 1, 2, 3, 4, 5, 6, 7  --> 4
    findMedianSortedSeq(Array(1, 3, 5), Vector(2, 4, 6, 7)) should ===(4.0)
    // 1, 2, 3, 4, 5, 6, 7，8  --> (4 + 5) / 2 == 4.5
    findMedianSortedSeq(Array(1, 3, 5, 7), Vector(2, 4, 6, 8)) should ===(4.5)
  }
}
