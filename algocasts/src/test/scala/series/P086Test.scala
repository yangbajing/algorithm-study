package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P086Test extends AnyWordSpec with Matchers {
  import P086._
  "Dutch national flag problem" should {
    "count" in {
      val arr = Array(2, 1, 2, 1, 0)
      sortThreeColorsCount(arr)
      arr shouldBe Array(0, 1, 1, 2, 2)
    }
    "swap" in {
      val arr = Array(2, 1, 2, 1, 0)
      sortThreeColorsSwap(arr)
      arr shouldBe Array(0, 1, 1, 2, 2)
    }
  }
}
