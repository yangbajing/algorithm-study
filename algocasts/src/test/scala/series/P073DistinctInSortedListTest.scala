package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P073DistinctInSortedListTest extends AnyWordSpec with Matchers {
  import P073DistinctInSortedList._
  "Distinct in sorted list" should {
    "distinctInSortedList" in {
      distinctInSortedList(ListNode(1, ListNode(1, ListNode(2, ListNode(2, ListNode(4)))))) should be(
        ListNode(1, ListNode(2, ListNode(4))))
    }
  }
}
