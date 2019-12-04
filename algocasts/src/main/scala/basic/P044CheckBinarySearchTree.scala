package basic

object P044CheckBinarySearchTree {
  // Time: O(n), Space: O(n)
  def isValidBST[T](tree: TreeNode[T])(implicit ev1: T => Ordered[T]): Boolean = {
    isValidSBTBound(tree, null, null)
  }

  private def isValidSBTBound[T](node: TreeNode[T], lower: TreeNode[T], upper: TreeNode[T])(
      implicit ev1: T => Ordered[T]): Boolean = {
    if (node == null) true
    else if (lower != null && lower.value >= node.value) {
      println(s"lower >= node, ${lower.value} >= ${node.value}")
      false
    } else if (upper != null && upper.value <= node.value) {
      println(s"upper <= node, ${upper.value} <= ${node.value}")
      false
    } else isValidSBTBound(node.left, lower, node) && isValidSBTBound(node.right, node, upper)
  }
}
