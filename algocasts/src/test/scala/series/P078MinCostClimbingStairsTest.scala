package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P078MinCostClimbingStairsTest extends AnyWordSpec with Matchers {
  import P078MinCostClimbingStairs._
  "Min cost climbing stairs" should {
    "minCostClimbingStairs(Vector(1, 2, 4, 2)) == 4" in { minCostClimbingStairs(Vector(1, 2, 4, 2)) shouldBe 4 }
    "minCostClimbingStairs(Vector(1, 4 4, 2, 2)) == 6" in { minCostClimbingStairs(Vector(1, 4, 4, 2, 4)) shouldBe 6 }
    "minCostClimbingStairsO1(Vector(1, 2, 4, 2)) == 4" in { minCostClimbingStairsO1(Vector(1, 2, 4, 2)) shouldBe 4 }
    "minCostClimbingStairsO1(Vector(1, 2, 4, 4, 2)) == 6" in {
      minCostClimbingStairsO1(Vector(1, 2, 4, 4, 2)) shouldBe 6
    }
  }
}
