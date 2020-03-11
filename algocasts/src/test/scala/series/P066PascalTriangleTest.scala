package series

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P066PascalTriangleTest extends AnyFunSuite with Matchers {
  import P066PascalTriangle._

  test("pascalTriangle(5)") {
    pascalTriangle(5) should be(Array(Array(1), Array(1, 1), Array(1, 2, 1), Array(1, 3, 3, 1), Array(1, 4, 6, 4, 1)))
  }
}
