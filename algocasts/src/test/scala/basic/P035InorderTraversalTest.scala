package basic

import org.scalatest.{ FunSuite, Matchers }

class P035InorderTraversalTest extends FunSuite with Matchers {
  import P035InorderTraversal._

  test("test") {
    val tree = TreeNode(1, TreeNode(2, right = TreeNode(4, TreeNode(5))), TreeNode(3))
    val result = inorderTraversalIterative(tree)
    result should be(Seq(2, 5, 4, 1, 3))
    result should be(inorderTraversalRecursive(tree))
  }
}
