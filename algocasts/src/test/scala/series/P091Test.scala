package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P091Test extends AnyWordSpec with Matchers {
  import P091._
  "P091" should {
    "searchInRotatedSortedArray" in {
      searchInRotatedSortedArray(Array(5, 6, 7, 8, 1, 2, 3, 4), 6) shouldBe 1
      searchInRotatedSortedArray(Array(5, 6, 7, 8, 1, 2, 3, 4), 3) shouldBe 6
    }
  }
}
