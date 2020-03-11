package series

import scala.collection.mutable

/**
 * P62. 路径和是否等于给定值
 * https://algocasts.io/series/algo-problems-51-100/episodes/17WMBomj
 * 这个题目说的是，给你一棵二叉树和一个整数，你要判断这棵二叉树上是否存在一条从根到叶子节点的路径，这条路径上所有节点中的数字相加等于给你的整数。
 *
 * 比如说，给你的二叉树是：
 * <pre>
 *     1
 *   /   \
 *  2     4
 *       / \
 *      8  16
 * </pre>
 * 给你的整数是 13。在这棵二叉树中存在一条从根到叶子节点的路径 1->4->8，路径上的数字加起来等于 13，于是要返回 true。
 */
object P062BSTHasPathSum {
  // Time: O(n), Space: O(n)
  def hasPathSumRecursive(root: TreeNode[Int], sum: Int): Boolean = {
    if (null == root) false
    else if (root.left == null && root.right == null) root.value == sum
    else hasPathSumRecursive(root.left, sum - root.value) || hasPathSumRecursive(root.right, sum - root.value)
  }

  // Time: O(n), Space: O(n)
  def hasPathSumIterative(root: TreeNode[Int], sum: Int): Boolean = {
    if (null == root) return false

    val stack = mutable.Stack[TreeNode[Int]](root)
    val sumStack = mutable.Stack[Int](sum)

    while (stack.nonEmpty) {
      val node = stack.pop()
      val n = sumStack.pop()

      if (node.left == null && node.right == null && node.value == n) return true

      if (node.left != null) {
        stack.push(node.left)
        sumStack.push(n - node.value)
      }
      if (node.right != null) {
        stack.push(node.right)
        sumStack.push(n - node.value)
      }
    }

    false
  }
}
