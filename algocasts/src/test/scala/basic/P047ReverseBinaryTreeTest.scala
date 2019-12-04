package basic

import org.scalatest.{ FunSuite, Matchers }

class P047ReverseBinaryTreeTest extends FunSuite with Matchers {
  import P047ReverseBinaryTree._
  private val expectedTree = TreeNode(1, TreeNode(4, TreeNode(16), TreeNode(8)), TreeNode(2))
  private def makeTree(): TreeNode[Int] = TreeNode(1, TreeNode(2), TreeNode(4, TreeNode(8), TreeNode(16)))

  test("reverseBinaryTreeRecursive") {
    reverseBinaryTreeRecursive(makeTree()) should be(expectedTree)
  }
  test("reverseBinaryTreeIterative") {
    reverseBinaryTreeIterative(makeTree()) should be(expectedTree)
  }
}
