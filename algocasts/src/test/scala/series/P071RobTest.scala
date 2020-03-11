package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P071RobTest extends AnyWordSpec with Matchers {
  import P071Rob._
  "Rob" should {
    "robO1(Vector(8, 1, 2, 9, 6))" in { robO1(Vector(8, 1, 2, 9, 6)) shouldBe 17 }
  }
}
