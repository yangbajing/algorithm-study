package basic

import org.scalatest.{ BeforeAndAfterAll, FunSuite, Matchers }

class P027IsCycleListTest extends FunSuite with Matchers with BeforeAndAfterAll {
  import P027IsCycleList._
  private val list1 = ListNode(3, ListNode(4, ListNode(5, ListNode(6, ListNode(7)))))
  private var list2: ListNode[Int] = _

  override protected def beforeAll(): Unit = {
    val last = ListNode(7)
    list2 = ListNode(3, ListNode(4, ListNode(5, ListNode(6, last))))
    last.next = list2.next
  }

  test("testIsCycleWithTowPointer") {
    isCycleWithHashSet(list1) should ===(false)
    isCycleWithHashSet(list2) should ===(true)
  }

  test("testIsCycleWithHashSet") {
    isCycleWithTowPointer(list1) should ===(false)
    isCycleWithTowPointer(list2) should ===(true)
  }
}
