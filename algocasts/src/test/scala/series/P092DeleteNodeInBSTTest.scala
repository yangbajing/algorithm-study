package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P092DeleteNodeInBSTTest extends AnyWordSpec with Matchers {
  import P092DeleteNodeInBST._
  "P092DeleteNodeInBST" should {
    "deleteNodeInBST" in {
      val original = TreeNode(1, TreeNode(0), TreeNode(4, TreeNode(2), TreeNode(8)))
      val result = deleteNodeInBST(original, 4)
      println(original)
      println(result)
    }
  }
}
