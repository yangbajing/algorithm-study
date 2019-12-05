package series

import org.scalatest.{ FunSuite, Matchers }

class P054AlgoCastsTest extends FunSuite with Matchers {
  import P054AlgoCasts._
  test("testSqrtNewton") {
    sqrtNewton(8) should be(2)
    sqrtNewton(9) should be(3)
  }
}
