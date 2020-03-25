package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P090MergeSortedListsTest extends AnyWordSpec with Matchers {
  import P090MergeSortedLists._
  "Merge sorted lists" should {
    val result = ListNode.create(0, 1, 1, 2, 2, 4, 4, 8)
    "With divide conquer" in {
      val l1 = ListNode.create(1, 2, 4)
      val l2 = ListNode.create(1, 4, 8)
      val l3 = ListNode.create(0, 2)
      mergeWithDivideConquer(Vector(l1, l2, l3)) shouldBe result
    }
    "With min heap" in {
      val l1 = ListNode.create(1, 2, 4)
      val l2 = ListNode.create(1, 4, 8)
      val l3 = ListNode.create(0, 2)
      mergeWithMinHeap(l1, l2, l3) shouldBe result
    }
    "With one by one" in {
      val l1 = ListNode.create(1, 2, 4)
      val l2 = ListNode.create(1, 4, 8)
      val l3 = ListNode.create(0, 2)
      mergeWithOneByOne(l1, l2, l3) shouldBe result
    }
  }
}
