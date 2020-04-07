package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P095LongestTest extends AnyWordSpec with Matchers {
  import P095Longest._
  "P095Longest" should {
    "lengthOfLongestConsecutiveSequenceSorting" in {
      lengthOfLongestConsecutiveSequenceSorting(Array(8, 4, 2, 1, 2, 3, 6)) shouldBe 4
    }
    "lengthOfLongestConsecutiveSequenceSet" in {
      lengthOfLongestConsecutiveSequenceSet(Array(8, 4, 2, 1, 2, 3, 6)) shouldBe 4
    }
  }
}
