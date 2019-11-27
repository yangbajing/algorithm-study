package basic

import org.scalatest.{ FunSuite, Matchers }

class P022BinaryTreeMaxDepthTest extends FunSuite with Matchers {
  import P022BinaryTreeMaxDepth._
  test("maxDepth") {
    maxDepth(TreeNode(1, TreeNode(2))) should ===(2)
    maxDepth(TreeNode(1, TreeNode(2), TreeNode(4, TreeNode(8), TreeNode(16)))) should ===(3)
  }
  test("maxDepthIterative") {
    maxDepthIterative(TreeNode(1, TreeNode(2))) should ===(2)
    maxDepthIterative(TreeNode(1, TreeNode(2), TreeNode(4, TreeNode(8), TreeNode(16)))) should ===(3)
  }
}
