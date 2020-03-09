package series

/**
 * P63. 用前序和中序遍历序列构建二叉树
 * https://algocasts.io/series/algo-problems-51-100/episodes/M0G2DaWz
 * 这个题目说的是，给你一棵二叉树的前序和中序遍历序列，你要根据这两个序列构建这棵二叉树。假设这棵二叉树节点上没有重复的数字。
 *
 * 比如说，给你的前序遍历序列和中序遍历序列分别是：
 * <pre>
 * 前序遍历序列：1, 2, 4, 8, 16
 * 中序遍历序列：2, 1, 8, 4, 16
 *
 * 你要返回用它们构建出的二叉树，是：
 *
 *     1
 *   /   \
 *  2     4
 *       / \
 *      8  16
 * </pre>
 */
object P063PreInBuildTree {
  case class TreeNode(value: Int, var left: TreeNode = null, var right: TreeNode = null)

  // Time: O(n), Space: O(n)
  def buildTree(pre: IndexedSeq[Int], in: IndexedSeq[Int]): TreeNode = {
    val inPos = in.zipWithIndex.map { case (n, i) => n -> i }.toMap

    def _buildTree(preStart: Int, preEnd: Int, inStart: Int): TreeNode = {
      if (preStart > preEnd) return null

      val root = TreeNode(pre(preStart))
      val rootIdx = inPos(root.value)
      val leftLen = rootIdx - inStart
      root.left = _buildTree(preStart + 1, preStart + leftLen, inStart)
      root.right = _buildTree(preStart + leftLen + 1, preEnd, rootIdx + 1)
      root
    }

    _buildTree(0, pre.length - 1, 0)
  }
}
