package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P094NodeOfCycleTest extends AnyWordSpec with Matchers {
  import P094NodeOfCycle._
  "P094NodeOfCycle" should {
    val node = ListNode(2)
    node.next = ListNode(4, ListNode(8, node))
    val list = ListNode(1, node)
    "startNodeOfCycleHashSet" in { startNodeOfCycleHashSet(list) shouldBe node }
    "startNodeOfCycleTwoPointer" in { startNodeOfCycleTwoPointer(list) shouldBe node }
  }
}
