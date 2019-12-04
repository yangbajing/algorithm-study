package basic

import scala.collection.mutable

/**
 * P47. 翻转二叉树
 * https://algocasts.io/series/algo-problems-1-50/episodes/6emEEjmV
 * 这个题目说的是，给你一棵二叉树，你要把它左右镜像翻转，然后返回翻转后的二叉树。
 * <pre>
 * 比如说，给你的二叉树是：
 *
 *      1
 *    /   \
 *   2     4
 *        / \
 *       8  16
 *
 * 左右翻转后的二叉树是：
 *
 *       1
 *     /   \
 *    4     2
 *   / \
 *  16  8
 *
 * 我们可以看到，二叉树上所有节点都沿中轴线左右互换了位置。
 * </pre>
 */
object P047ReverseBinaryTree {
  def reverseBinaryTreeRecursive[T](tree: TreeNode[T])(implicit ev1: T => Ordered[T]): TreeNode[T] = {
    if (tree == null) tree else _reverseBinaryTreeRecursive(tree)
  }

  def reverseBinaryTreeIterative[T](tree: TreeNode[T])(implicit ev1: T => Ordered[T]): TreeNode[T] = {
    if (tree == null) tree else _reverseBinaryTreeIterative(tree)
  }

  private def _reverseBinaryTreeRecursive[T](node: TreeNode[T]): TreeNode[T] = {
    if (node != null) {
      val tmp = node.left
      node.left = node.right
      node.right = tmp
      _reverseBinaryTreeRecursive(node.left)
      _reverseBinaryTreeRecursive(node.right)
    }
    node
  }
  private def _reverseBinaryTreeIterative[T](tree: TreeNode[T]): TreeNode[T] = {
    val q = mutable.Queue[TreeNode[T]](tree)
    while (q.nonEmpty) {
      val node = q.dequeue()
      val tmp = node.left
      node.left = node.right
      node.right = tmp
      if (node.left != null) q.enqueue(node.left)
      if (node.right != null) q.enqueue(node.right)
    }
    tree
  }
}
