package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.math.BigDecimal.RoundingMode

class P072RobCycleTest extends AnyWordSpec with Matchers {
  import P072RobCycle._
  "Rob" should {
    "robO1(List(8.5, 1.1, 2.7, 9.6, 6.1))" in {
      val result = robO1(List(8.5, 1.1, 2.7, 9.6, 6.1))
      format(result) shouldBe 18.1
    }
    "robO1(Vector(8, 1, 2, 9))" in {
      robO1(Vector(8, 1, 2, 9)) shouldBe 10
    }
    "robO1(Array(8.1, 1.2, 2.2, 9.2))" in {
      val result = robO1(Array(8.1, 1.2, 2.2, 9.2))
      format(result) shouldBe 10.4
    }
  }

  private def format(d: Double) = BigDecimal(d).setScale(1, RoundingMode.HALF_UP).doubleValue
}
