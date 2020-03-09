package series

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P059KthLargestTest extends AnyFunSuite with Matchers {
  import P059KthLargest._
  test("testFindKthLargestQuickSelect") {
    findKthLargestQuickSelect(Array(1, 2, 3, 4, 5), 2) should be(4)
  }

  test("testFindKthLargestMinHeap") {
    findKthLargestMinHeap(Array(1, 2, 3, 4, 5), 2) should be(4)
  }
}
