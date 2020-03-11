package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P067BSTSearchTest extends AnyWordSpec with Matchers {
  import P067BSTSearch._
  "Binary search tree" should {
    val tree = TreeNode(8, TreeNode(2, TreeNode(1), TreeNode(4)), TreeNode(16))

    "recursive" in {
      bstSearchRecursive(tree, 4) shouldBe TreeNode(4)
      bstSearchRecursive(tree, 2) shouldBe TreeNode(2, TreeNode(1), TreeNode(4))
      bstSearchRecursive(tree, 8) shouldBe tree
      bstSearchRecursive(tree, 32) shouldBe null
    }

    "iterative" in {
      bstSearchIterative(tree, 4) shouldBe TreeNode(4)
      bstSearchIterative(tree, 2) shouldBe TreeNode(2, TreeNode(1), TreeNode(4))
      bstSearchIterative(tree, 8) shouldBe tree
      bstSearchIterative(tree, 32) shouldBe null
    }
  }
}
