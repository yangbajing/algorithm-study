package series

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class P068OrderArrayBuildBSTTest extends AnyWordSpec with Matchers {
  import P068OrderArrayBuildBST._
  "Build binary search tree" should {
    "recursive" in {
      val arr = Vector('a', 'b', 'c', 'd', 'e')
      val tree = TreeNode('c', TreeNode('a', right = TreeNode('b')), TreeNode('d', right = TreeNode('e')))
      sortedArrayToBSTRecursive(arr) shouldBe tree
      sortedArrayToBSTRecursive(arr) should not be TreeNode('c')
    }
  }
}
