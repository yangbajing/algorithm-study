package series

/**
 * P64. 用中序和后序遍历序列构建二叉树
 * https://algocasts.io/series/algo-problems-51-100/episodes/QqpnP6mk
 * 这个题目说的是，给你一棵二叉树的中序和后序遍历序列，你要根据这两个序列构建这棵二叉树。假设这棵二叉树节点上没有重复的数字。
 * <pre>
 * 比如说，给你的中序遍历序列和后序遍历序列分别是：
 *
 * 中序遍历序列：2, 1, 8, 4, 16
 * 后序遍历序列：2, 8, 16, 4, 1
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
object P064InPostBuildTree {
  // Time: O(n), Space: O(n)
  def buildTree[T](in: IndexedSeq[T], post: IndexedSeq[T]): TreeNode[T] = {
    val inPos = in.zipWithIndex.toMap

    def build(postStart: Int, postEnd: Int, inStart: Int): TreeNode[T] = {
      if (postStart > postEnd) return null

      val root = TreeNode(post(postEnd))
      val rootIdx = inPos(root.value)
      val leftCount = rootIdx - inStart
      root.left = build(postStart, postStart + leftCount - 1, inStart)
      root.right = build(postStart + leftCount, postEnd - 1, rootIdx + 1)
      root
    }

    build(0, post.length - 1, 0)
  }
}
