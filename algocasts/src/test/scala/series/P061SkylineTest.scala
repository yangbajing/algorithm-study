package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P061SkylineTest extends AnyWordSpec with Matchers {
  import P061Skyline._

  private val data1 = Vector(Rect(1, 3, 2), Rect(2, 4, 3), Rect(5, 9, 2), Rect(6, 8, 4))
  private val result1 = Vector((1, 2), (2, 3), (4, 0), (5, 2), (6, 4), (8, 2), (9, 0))
  private val data2 = Vector(Rect(2, 4, 2), Rect(2, 4, 3), Rect(5, 7, 2), Rect(7, 9, 4))
  private val result2 = Vector((2, 3), (4, 0), (5, 2), (7, 4), (9, 0))

  "MaxHeap" should {
    "X axis does not coincide" in {
      skylinePointsMaxHeap(data1) shouldBe result1
    }

    "X axis coincidence" in {
      skylinePointsMaxHeap(data2) shouldBe result2
    }
  }

  "TreeMap" should {
    "X axis does not coincide" in {
      skylinePointsTreeMap(data1) shouldBe result1
    }

    "X axis coincidence" in {
      skylinePointsTreeMap(data2) shouldBe result2
    }
  }
}
