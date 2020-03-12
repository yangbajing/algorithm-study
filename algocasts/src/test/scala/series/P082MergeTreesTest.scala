package series

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class P082MergeTreesTest extends AnyFunSuite with Matchers {
  import P082MergeTrees._
  test("Merge trees") {
    val t1 = TreeNode(1, TreeNode(3, right = TreeNode(7)), TreeNode(5, right = TreeNode(9)))
    val t2 = TreeNode(2, TreeNode(4, TreeNode(8)), TreeNode(6))
    val result = mergeTrees(t1, t2)
    println(result)
    result should be(TreeNode(3, TreeNode(7, TreeNode(8), TreeNode(7)), TreeNode(11, right = TreeNode(9))))
  }
}
