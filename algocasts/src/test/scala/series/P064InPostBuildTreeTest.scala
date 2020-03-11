package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P064InPostBuildTreeTest extends AnyWordSpec with Matchers {
  import P064InPostBuildTree._

  "inPost" should {
    "tree" in {
      buildTree(Vector(2, 1, 8, 4, 16), Vector(2, 8, 16, 4, 1)) should be(
        TreeNode(1, TreeNode(2), TreeNode(4, TreeNode(8), TreeNode(16))))
    }
  }
}
