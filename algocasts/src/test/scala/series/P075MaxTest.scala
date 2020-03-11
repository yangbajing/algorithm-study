package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P075MaxTest extends AnyWordSpec with Matchers {
  import P075Max._
  "Max" should {
    "max(8L, 1L, -2L, 4L, -1L) == 64L" in {
      maxProductSubseq(Seq[Long](8, 1, -2, 4, -1)) shouldBe 64L
    }
    "max(8, 1, -2, 4) == 8" in {
      maxProductSubseq(Seq(8, 1, -2, 4)) shouldBe 8
    }
    "max(8, 1, -2, 4, 3) == 12" in {
      maxProductSubseq(Array(8, 1, -2, 4, 3)) shouldBe 12
    }
  }
}
