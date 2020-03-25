package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P087NumberOfIslandsTest extends AnyWordSpec with Matchers {
  import P087NumberOfIslands._
  "NumberOfIslands" should {
    "1" in {
      val g = Array(Array(1, 0, 0), Array(0, 1, 1), Array(0, 1, 1))
      numberOfIslands(g) shouldBe 2
    }
    "2" in {
      val g = Array(Array(1, 0, 0), Array(1, 0, 1), Array(0, 1, 1))
      numberOfIslands(g) shouldBe 2
    }
  }
}
