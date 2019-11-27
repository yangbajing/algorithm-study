package basic

import java.util.Objects

/**
 * P22. 二叉树的最大深度
 * https://algocasts.io/series/algo-problems-1-50/episodes/jwmB5W8Z
 * 这个题目说的是，给你一棵二叉树，你要找到从根节点到最远叶子节点的深度。
 */
object P022BinaryTreeMaxDepth {
  // Time: O(n), Space: O(n)
  def maxDepth(tree: TreeNode): Int = {
    if (Objects.isNull(tree)) 0
    else math.max(maxDepth(tree.left), maxDepth(tree.right)) + 1
  }

  // Time: O(n), Space: O(N)
  def maxDepthIterative(tree: TreeNode): Int = {
    println(s"maxDepthIterative($tree)")
    if (Objects.isNull(tree)) 0
    else {
      var depth = 0
      var queue = List(tree)
      while (queue.nonEmpty) {
        queue = queue.flatMap(node => Option(node.left) ++ Option(node.right))
        depth += 1
      }
      depth
    }
  }
}
