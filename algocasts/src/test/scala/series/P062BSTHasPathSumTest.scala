package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P062BSTHasPathSumTest extends AnyWordSpec with Matchers {
  import P062BSTHasPathSum._
  private val tree = TreeNode(1, TreeNode(2), TreeNode(4, TreeNode(8), TreeNode(16)))

  "Recursive" should {
    "Has true" in { hasPathSumRecursive(tree, 13) shouldBe true }

    "Has false" in { hasPathSumRecursive(tree, 14) shouldBe false }
  }
  "Iterative" should {
    "Has true" in { hasPathSumIterative(tree, 13) shouldBe true }

    "Has false" in { hasPathSumIterative(tree, 14) shouldBe false }
  }
}
