package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P079LengthTest extends AnyWordSpec with Matchers {
  import P079Length._
  "Length" should {
    "lengthOfLISDP" in { lengthOfLISDP(Vector(1, 8, 2, 6, 4, 5)) shouldBe 4 }
    "lengthOfLISBinarySearch" in { lengthOfLISBinarySearch(Vector(1, 8, 2, 6, 4, 5)) shouldBe 4 }
  }
}
