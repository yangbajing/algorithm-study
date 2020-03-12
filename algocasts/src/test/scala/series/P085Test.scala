package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P085Test extends AnyWordSpec with Matchers {
  import P085._
  "test" should {
    "dp(Array(1, 2), 4) == 2" in {
      minCoinCombination(Array(1, 2), 4) should be(2)
    }
    "dp(Array(1, 2), 5) == 3" in {
      minCoinCombination(Array(1, 2), 5) should be(3)
    }
    "dp(Array(1, 2, 3), 4) == 2" in {
      minCoinCombination(Array(1, 2, 3), 4) should be(2)
    }
    "dp(Array(1, 2, 5), 10) == 2" in {
      minCoinCombination(Array(1, 2, 5), 10) should be(2)
    }
    "dp(Array(5, 2), 3) == -1" in {
      minCoinCombination(Array(5, 2), 3) should be(-1)
    }
  }
}
