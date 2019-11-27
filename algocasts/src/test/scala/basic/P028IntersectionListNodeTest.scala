package basic

import org.scalatest.{ FunSuite, Matchers }

class P028IntersectionListNodeTest extends FunSuite with Matchers {
  import P028IntersectionListNode._
  class Item(s: String) {
    override def toString: String = s
  }
  object Item {
    def apply(s: String) = new Item(s)
  }

  test("testGetIntersectionNode") {
    val node = Item("Y")
    getIntersectionNode(
      List(Item("a"), Item("b"), Item("c"), node, Item("e"), Item("f")),
      Vector(Item("a"), Item("c"), Item("d"), Item("e"))) should ===(None)
    getIntersectionNode(
      List(Item("a"), Item("b"), Item("c"), node, Item("e"), Item("f")),
      Vector(Item("a"), Item("c"), node, Item("e"))) should ===(Some(node))
  }
}
