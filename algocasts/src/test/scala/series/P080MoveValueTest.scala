package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.collection.mutable

class P080MoveValueTest extends AnyWordSpec with Matchers {
  import P080MoveValue._
  "Move value" should {
    "moveValueSwap(Array(0, 1, 2, 0, 4), 0)" in {
      val arr = Array(0, 1, 2, 0, 4)
      moveValueSwap(arr, 0)
      arr shouldBe Array(1, 2, 4, 0, 0)
    }
    """moveValueSwap(mutable.IndexedSeq("Y", "A", "B", "J", "A", "A", "X"), "A")""" in {
      val arr = mutable.IndexedSeq("Y", "A", "B", "J", "A", "A", "X")
      moveValueSwap(arr, "A")
      arr shouldBe Seq("Y", "B", "J", "X", "A", "A", "A")
    }
    "moveValueSwap(Array(3, 4, 2, 1, 4, 7, -5), 4)" in {
      val arr = Array(3, 4, 2, 1, 4, 7, -5)
      moveValueSwap(arr, 4)
      arr shouldBe Array(3, 2, 1, 7, -5, 4, 4)
    }
  }
}
