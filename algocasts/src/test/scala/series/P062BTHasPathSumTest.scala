package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P062BTHasPathSumTest extends AnyWordSpec with Matchers {
  import P062BTHasPathSum._
  private val tree = new TreeNode(1, new TreeNode(2), new TreeNode(4, new TreeNode(8), new TreeNode(16)))

  "Recursive" should {
    "Has true" in { hasPathSumRecursive(tree, 13) shouldBe true }

    "Has false" in { hasPathSumRecursive(tree, 14) shouldBe false }
  }
  "Iterative" should {
    "Has true" in { hasPathSumIterative(tree, 13) shouldBe true }

    "Has false" in { hasPathSumIterative(tree, 14) shouldBe false }
  }
}
