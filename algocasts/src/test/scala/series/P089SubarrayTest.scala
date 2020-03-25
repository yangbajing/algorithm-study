package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P089SubarrayTest extends AnyWordSpec with Matchers {
  import P089Subarray._
  "Subarray" should {
    "subarrayOnePass" in { subarrayOnePass(Array(0, 2, 4, 1, 8)) shouldBe 3 }
    "subarrayTwoPass" in { subarrayTwoPass(Array(0, 2, 4, 1, 8)) shouldBe 3 }
    "subarrayBySorting" in { subarrayBySorting(Array(0, 2, 4, 1, 8)) shouldBe 3 }
  }
}
