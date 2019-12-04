package basic

import scala.collection.mutable

/**
 * P35. 二叉树中序遍历
 * https://algocasts.io/series/algo-problems-1-50/episodes/yRp3ym4x
 * 这个题目说的是，给你一个二叉树，你要返回一个数组，表示二叉树中序遍历的结果。
 * <pre>
 * 比如说，给你的二叉树是：
 *
 *      1
 *    /   \
 *   2     3
 *    \
 *     4
 *    /
 *   5
 *
 * 你要返回的中序遍历结果是：2, 5, 4, 1, 3
 * </pre>
 */
object P035InorderTraversal {
  // Time: O(n). Space: O(n)
  def inorderTraversalRecursive[T](tree: TreeNode[T]): Seq[T] = {
    if (tree == null) Nil
    else (inorderTraversalRecursive(tree.left) :+ tree.value) ++ inorderTraversalRecursive(tree.right)
  }

  // Time: O(n). Space: O(n)
  def inorderTraversalIterative[T](tree: TreeNode[T]): Seq[T] = {
    val stack = mutable.Stack[TreeNode[T]]()
    var results = Vector[T]()
    var root = tree
    while (root != null || stack.nonEmpty) {
      while (root != null) {
        stack.push(root)
        root = root.left
      }
      root = stack.pop()
      results :+= root.value
      root = root.right
    }
    results
  }
}
