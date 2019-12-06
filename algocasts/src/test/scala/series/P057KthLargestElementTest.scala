package series

import org.scalatest.{ FunSuite, Matchers }

class P057KthLargestElementTest extends FunSuite with Matchers {
  import P057KthLargestElement._
  test("test") {
    val stream = new KthLargestElement(List(1, 5), 3)
    stream.max should be(empty)
    stream.add(2)
    stream.max should be(Some(1))
    stream.add(8)
    stream.max should be(Some(2))
    stream.add(9)
    stream.max should be(Some(5))
    stream.add(4)
    stream.max should be(Some(5))
    stream.add(6)
    stream.max should be(Some(6))
  }
}
