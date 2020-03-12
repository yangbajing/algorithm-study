package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P083ReverseWordsTest extends AnyWordSpec with Matchers {
  import P083ReverseWords._
  "Reverse words" should {
    """"I am Scalar." reverse to "I ma .ralacS""" in {
      reverseWords("I am Scalar.") shouldBe "I ma .ralacS"
    }
  }
}
