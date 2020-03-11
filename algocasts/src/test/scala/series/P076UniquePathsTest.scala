package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P076UniquePathsTest extends AnyWordSpec with Matchers {
  import P076UniquePaths._
  "Unique Paths" should {
    "dp" in { uniquePathsDP(2, 4) shouldBe 4 }
    "math" in { uniquePathsMath(2, 4) shouldBe 4 }
  }
}
