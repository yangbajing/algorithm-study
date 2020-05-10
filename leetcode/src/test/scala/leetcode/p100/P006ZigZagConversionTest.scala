package leetcode.p100

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P006ZigZagConversionTest extends AnyWordSpec with Matchers {
  import P006ZigZagConversion._
  val S = "PAYPALISHIRING"
  "P006ZigZagConversionTest" should {
    "convert1" in { convert(S, 3) shouldBe "PAHNAPLSIIGYIR" }
    "convert2" in { convert(S, 4) shouldBe "PINALSIGYAHRPI" }
  }
}
