package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P069PalindromicSplitTest extends AnyWordSpec with Matchers {
  import P069PalindromicSplit._
  "Palindromic split" should {
    "partition(aba)" in {
      partition("aba") should contain theSameElementsAs Seq(Seq("a", "b", "a"), Seq("aba"))
    }
    "partition(abad)" in {
      partition("abad") should contain theSameElementsAs Seq(Seq("a", "b", "a", "d"), Seq("aba", "d"))
    }
    "expand(aba)" in {
      expand("aba") should contain theSameElementsAs Seq("a", "b", "a", "aba")
    }
    "expand(abad)" in {
      expand("abad") should contain theSameElementsAs Seq("a", "b", "a", "aba", "d")
    }
  }
}
