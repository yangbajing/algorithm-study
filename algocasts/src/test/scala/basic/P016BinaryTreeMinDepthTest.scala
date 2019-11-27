package basic

import org.scalatest.{ FunSuite, Matchers }

class P016BinaryTreeMinDepthTest extends FunSuite with Matchers {
  import P016BinaryTreeMinDepth._
  test("minDepth") {
    minDepth(TreeNode(1, TreeNode(2), TreeNode(4, TreeNode(8), TreeNode(16)))) should ===(2)
    minDepth(TreeNode(
      1,
      TreeNode(2, TreeNode(3), TreeNode(5, right = TreeNode(6))),
      TreeNode(12, TreeNode(14), TreeNode(16)))) should ===(3)
  }
}
