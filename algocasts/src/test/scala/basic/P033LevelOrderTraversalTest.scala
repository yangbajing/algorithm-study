package basic

import org.scalatest.{ FunSuite, Matchers }

class P033LevelOrderTraversalTest extends FunSuite with Matchers {
  import P033LevelOrderTraversal._
  test("level max 2") {
    val tree = TreeNode(1, TreeNode(2), TreeNode(4, TreeNode(8), TreeNode(16)))
    levelOrderTraversal(tree) should be(Seq(Seq(1), Seq(2, 4), Seq(8, 16)))
  }
  test("level max 4") {
    val tree = TreeNode(1, TreeNode(2, TreeNode(3), TreeNode(4)), TreeNode(5, TreeNode(6), TreeNode(7)))
    levelOrderTraversal(tree) should be(Seq(Seq(1), Seq(2, 5), Seq(3, 4, 6, 7)))
  }
}
