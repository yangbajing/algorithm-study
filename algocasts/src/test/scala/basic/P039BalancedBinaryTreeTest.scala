package basic

import org.scalatest.{ FunSuite, Matchers }

class P039BalancedBinaryTreeTest extends FunSuite with Matchers {
  import P039BalancedBinaryTree._

  private val tree1 = TreeNode(1, TreeNode(2), TreeNode(4, TreeNode(8), TreeNode(16)))
  private val tree2 = TreeNode(1, TreeNode(2), TreeNode(4, right = TreeNode(8, right = TreeNode(16))))

  test("testIsBalancedBinaryTreeTopDown") {
    isBalancedBinaryTreeTopDown(tree1) should be(true)
    isBalancedBinaryTreeTopDown(tree2) should be(false)
  }

  test("testIsBalancedBinaryTreeBottomUp") {
    isBalancedBinaryTreeBottomUp(tree1) should be(true)
    isBalancedBinaryTreeBottomUp(tree2) should be(false)
  }
}
