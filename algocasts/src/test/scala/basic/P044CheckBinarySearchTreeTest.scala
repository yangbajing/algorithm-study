package basic

import org.scalatest.{ FunSuite, Matchers }

class P044CheckBinarySearchTreeTest extends FunSuite with Matchers {
  import P044CheckBinarySearchTree._
  test("testIsValidBST") {
    isValidBST(TreeNode(4, TreeNode(2), TreeNode(6))) should be(true)
    isValidBST(TreeNode(4, TreeNode(2), TreeNode(6, TreeNode(3), TreeNode(8)))) should be(false)
    isValidBST(TreeNode(4, TreeNode(2), TreeNode(6, TreeNode(8), TreeNode(7)))) should be(false)
  }
}
