package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P074RemoveDuplicatesInSortedListTest extends AnyWordSpec with Matchers {
  import P074RemoveDuplicatesInSortedList._
  "Remove duplicates in sorted list" should {
    "removeDuplicatesInSortedList" in {
      removeDuplicatesInSortedList(ListNode(1, ListNode(1, ListNode(2, ListNode(4))))) should be(
        ListNode(2, ListNode(4)))
    }
  }
}
