package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P077UniquePathsWithObstaclesTest extends AnyWordSpec with Matchers {
  import P077UniquePathsWithObstacles._
  "Space O(m*n)" should {
    "(2, 4, 0 -> 3)" in { uniquePaths(2, 4, 0 -> 3) shouldBe 3 }
    "(2, 4, 0 -> 2)" in { uniquePaths(2, 4, 0 -> 2) shouldBe 2 }
    "(2, 4, 0 -> 1)" in { uniquePaths(2, 4, 0 -> 1) shouldBe 1 }
    "(4, 2, 3 -> 0)" in { uniquePaths(4, 2, 3 -> 0) shouldBe 3 }
    "(4, 2, 2 -> 0)" in { uniquePaths(4, 2, 2 -> 0) shouldBe 2 }
  }
  "Space O(min(m,n))" should {
    "(2, 4, 0 -> 3)" in { uniquePathsOn(2, 4, 0 -> 3) shouldBe 3 }
    "(2, 4, 0 -> 2)" in { uniquePathsOn(2, 4, 0 -> 2) shouldBe 2 }
    "(2, 4, 0 -> 1)" in { uniquePathsOn(2, 4, 0 -> 1) shouldBe 1 }
    "(4, 2, 3 -> 0)" in { uniquePathsOn(4, 2, 3 -> 0) shouldBe 3 }
    "(4, 2, 2 -> 0)" in { uniquePathsOn(4, 2, 2 -> 0) shouldBe 2 }
  }
  "Space O(col)" should {
    "(2, 4, 0 -> 3)" in { uniquePathsByCol(2, 4, 0 -> 3) shouldBe 3 }
    "(2, 4, 0 -> 2)" in { uniquePathsByCol(2, 4, 0 -> 2) shouldBe 2 }
    "(2, 4, 0 -> 1)" in { uniquePathsByCol(2, 4, 0 -> 1) shouldBe 1 }
    "(4, 2, 3 -> 0)" in { uniquePathsByCol(4, 2, 3 -> 0) shouldBe 3 }
    "(4, 2, 2 -> 0)" in { uniquePathsByCol(4, 2, 2 -> 0) shouldBe 2 }
  }
}
