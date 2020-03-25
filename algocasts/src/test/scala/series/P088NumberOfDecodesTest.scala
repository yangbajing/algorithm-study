package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P088NumberOfDecodesTest extends AnyWordSpec with Matchers {
  import P088NumberOfDecodes._
  "Number of decodes" should {
    "dp O1" in { numberOfDecodesDPO1("124") shouldBe 3 }
    "dp" in { numberOfDecodesDP("124") shouldBe 3 }
    "recursive" in { numberOfDecodesRecursive("124") shouldBe 3 }
  }
}
