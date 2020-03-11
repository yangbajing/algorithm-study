package series

import scala.collection.mutable

/**
 * P65. 二叉树前序遍历
 * https://algocasts.io/series/algo-problems-51-100/episodes/deG49vp1
 * 这个题目说的是，给你一个二叉树，你要返回一个数组，表示二叉树前序遍历的结果。
 * <pre>
 * 比如说，给你的二叉树是：
 *
 *     1
 *    / \
 *   2   3
 *    \
 *     4
 *    /
 *   5
 *
 * 你要返回的前序遍历结果是：
 *
 * 1, 2, 4, 5, 3
 * </pre>
 */
object P065BTPreOrderTraversal {
  // Time: O(n), Space: O(n)
  def preOrderTraversalRecursive[T](root: TreeNode[T]): Seq[T] = {
    val builder = Vector.newBuilder[T]

    def traversal(node: TreeNode[T]): Unit = if (node != null) {
      builder.addOne(node.value)
      traversal(node.left)
      traversal(node.right)
    }

    traversal(root)
    builder.result()
  }

  // Time: O(n), Space: O(n)
  def preOrderTraversalIterative[T](root: TreeNode[T]): Seq[T] = {
    if (root == null) return Vector()

    val builder = Vector.newBuilder[T]
    val stack = mutable.Stack[TreeNode[T]](root)

    while (stack.nonEmpty) {
      val node = stack.pop()
      builder.addOne(node.value)
      if (node.right != null) stack.push(node.right)
      if (node.left != null) stack.push(node.left)
    }

    builder.result()
  }
}
