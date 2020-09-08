package leetcode.p200

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * @author yangbajing <a href="mailto://yang.xunjing@qq.com">羊八井</a>
 * @since 2020-09-08 20:51
 */
class P144PreorderTraversalTest extends AnyWordSpec with Matchers {
  import P144PreorderTraversal._
  "P144PreorderTraversalTest" should {
    "preorderTraversal" in {
      val tree = new TreeNode(1)
      tree.right = new TreeNode(2)
      tree.right.left = new TreeNode(3)
      preorderTraversal(tree) shouldBe List(1, 2, 3)
    }

    "preorderTraversal recursive" in {
      val tree = new TreeNode(1)
      tree.right = new TreeNode(2)
      tree.right.left = new TreeNode(3)
      preorderTraversalWithRecursive(tree) shouldBe List(1, 2, 3)
    }
  }
}
