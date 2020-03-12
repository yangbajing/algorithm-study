package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P084Test extends AnyWordSpec with Matchers {
  import P084._
  "recursive" should {
    "recursive(4, Array(1, 2)) == 3" in {
      numberOfCoinCombinationRecursive(4, Array(1, 2)) should be(3)
    }

    "recursive(5, Array(1, 2)) == 3" in {
      numberOfCoinCombinationRecursive(5, Array(1, 2)) should be(3)
    }

    "recursive(4, Array(1, 2, 3)) == 4" in {
      numberOfCoinCombinationRecursive(4, Array(1, 2, 3)) should be(4)
    }

    "recursive(10, Array(1, 2, 5)) == 4" in {
      numberOfCoinCombinationRecursive(10, Array(1, 2, 5)) should be(10)
    }
  }

  "dp" should {
    "dp(4, Array(1, 2)) == 3" in {
      numberOfCoinCombinationDP(4, Array(1, 2)) should be(3)
    }

    "dp(5, Array(1, 2)) == 3" in {
      numberOfCoinCombinationDPOsum(5, Array(1, 2)) should be(3)
    }

    "dp(4, Array(1, 2, 3)) == 4" in {
      numberOfCoinCombinationDPOsum(4, Array(1, 2, 3)) should be(4)
    }

    "dp(10, Array(1, 2, 5)) == 4" in {
      numberOfCoinCombinationDPOsum(10, Array(1, 2, 5)) should be(10)
    }
  }
}
