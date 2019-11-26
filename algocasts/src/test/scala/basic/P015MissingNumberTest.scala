package basic

import org.scalatest.{ FunSuite, Matchers }

class P015MissingNumberTest extends FunSuite with Matchers {
  import P015MissingNumber._
  test("MissingNumber") {
    missingNumberScala(List(0, 1, 3, 4)) should ===(2)
    missingNumberScala(List(0, 1, 2, 4)) should ===(3)
    missingNumberScala(List(4, 1, 2, 0)) should ===(3)
    missingNumberScala(List(5, 1, 2, 3, 4)) should ===(0)
    missingNumberScala(List(4, 1, 0, 3, 2)) should ===(5)
  }
}
