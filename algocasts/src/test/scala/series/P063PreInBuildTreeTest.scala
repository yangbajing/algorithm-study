package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P063PreInBuildTreeTest extends AnyWordSpec with Matchers {
  import P063PreInBuildTree._

  "PreIn" should {
    "tree" in {
      buildTree(Vector(1, 2, 4, 8, 16), Vector(2, 1, 8, 4, 16)) should be(
        TreeNode(1, TreeNode(2), TreeNode(4, TreeNode(8), TreeNode(16))))
    }
  }
}
