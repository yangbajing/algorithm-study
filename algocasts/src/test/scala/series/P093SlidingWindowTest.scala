package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P093SlidingWindowTest extends AnyWordSpec with Matchers {
  import P093SlidingWindow._
  "P093SlidingWindow" should {
    "maxNumInSlidingWindowBruteForce" in {
      maxNumInSlidingWindowBruteForce(Array(0, 4, 2, 1, 0, 8, 2), 3) shouldBe Array(4, 4, 2, 8, 8)
    }
    "maxNumInSlidingWindowTreeMap" in {
      maxNumInSlidingWindowTreeMap(Array(0, 4, 2, 1, 0, 8, 2), 3) shouldBe Array(4, 4, 2, 8, 8)
    }
    "maxNumInSlidingWindowOn" in {
      maxNumInSlidingWindowOn(Array(0, 4, 2, 1, 0, 8, 2), 3) shouldBe Array(4, 4, 2, 8, 8)
    }
  }
}
