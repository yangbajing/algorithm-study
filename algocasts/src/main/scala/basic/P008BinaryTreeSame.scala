package basic

/**
 * P8. 判断二叉树是否相同
 * https://algocasts.io/series/algo-problems-1-50/episodes/eAGQlm4D
 * 这个题目说的是，给你两个二叉树，你要判断它们是否相同。这里所谓相同，指的是两棵树结构相同，并且相应节点上的数值相等。
 * <pre>
 * 比如说，给你的两棵二叉树都是：
 *
 *    1          1
 *   / \        / \
 *  2   4      2   4
 *
 * 它们的结构相同，相应节点上的值也相等，因此返回 true。 如果另一棵树是：
 *
 *    1
 *   / \
 *  2   5
 *
 * 或
 *
 *     1
 *    /
 *   2
 *  /
 * 4
 *
 * 两棵树则不相同，返回 false。
 * </pre>
 */
object P008BinaryTreeSame {
  case class TreeNode(value: Int, left: Option[TreeNode] = None, right: Option[TreeNode] = None)

  def isSameBinaryTreeRecursive(l: Option[TreeNode], r: Option[TreeNode]): Boolean = {
    if (l.isEmpty && r.isEmpty) true
    else if (l.isEmpty || r.isEmpty) false
    else {
      val left = l.get
      val right = r.get
      left.value == right.value && isSameBinaryTreeRecursive(left.left, right.left) && isSameBinaryTreeRecursive(
        left.right,
        right.right)
    }
  }

  def main(args: Array[String]): Unit = {
    val tree1 = TreeNode(1, Some(TreeNode(2, Some(TreeNode(6)), Some(TreeNode(8)))), Some(TreeNode(4)))
    val tree2 = TreeNode(1, Some(TreeNode(2, Some(TreeNode(6)), Some(TreeNode(8)))), Some(TreeNode(4)))

    val b = isSameBinaryTreeRecursive(Some(tree1), Some(tree2))
    println(b)
  }
}
