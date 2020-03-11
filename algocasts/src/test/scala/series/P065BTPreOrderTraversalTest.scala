package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P065BTPreOrderTraversalTest extends AnyWordSpec with Matchers {
  import P065BTPreOrderTraversal._

  "Pre order traversal" should {
    val tree = TreeNode(1, TreeNode(2, right = TreeNode(4, left = TreeNode(5))), TreeNode(3))
    val result = Seq(1, 2, 4, 5, 3)
    "recursive" in {
      preOrderTraversalRecursive(tree) shouldBe result
    }

    "iterative" in {
      preOrderTraversalIterative(tree) shouldBe result
    }
  }
}
