package basic

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
