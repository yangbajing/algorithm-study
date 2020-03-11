package series

/**
 * P68. 用有序数组构建二叉搜索树
 * https://algocasts.io/series/algo-problems-51-100/episodes/rLmP98Go
 * 这个题目说的是，给你一个递增排序的数组，你要用它构建一棵平衡的二叉搜索树。所谓平衡，是指对于这棵二叉搜索树上的每一个节点，它左右子树的高度差不能大于 1。
 * <pre>
 * 比如说，给你的递增数组是：
 *
 * 1, 2, 4, 8, 16
 *
 * 一种可能的构建方式是：
 *
 *    4
 *   / \
 *  1   8
 *   \   \
 *    2  16
 *
 * 首先，这是一棵二叉搜索树。对于任意的一个节点，它左子树上的数字都小于它；右子树上的数字都大于它。
 *
 * 另外这棵树是平衡的，因为任何一个节点的左右子树高度差都不大于 1 。
 *
 * 当然，这不是唯一的构建方式。比如也可以构建成：
 *
 *      4
 *     / \
 *    2   8
 *   /     \
 *  1      16
 *
 * 我们只需要返回任意一个平衡的二叉搜索树即可。
 * </pre>
 */
object P068OrderArrayBuildBST {
  // Time: O(n), Space: O(lg(n))
  def sortedArrayToBSTRecursive[T](arr: IndexedSeq[T])(implicit ord: Ordering[T]): TreeNode[T] = {
    require(arr != null && arr.nonEmpty)
    def build(start: Int, end: Int): TreeNode[T] = {
      if (start > end) return null

      val mid = start + (end - start) / 2
      val node = TreeNode(arr(mid))
      node.left = build(start, mid - 1)
      node.right = build(mid + 1, end)
      node
    }

    build(0, arr.length - 1)
  }
}
