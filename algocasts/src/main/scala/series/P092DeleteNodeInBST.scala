package series

/**
 * P92. 二叉搜索树中删除节点
 * 这个题目说的是，给你一棵二叉搜索树和一个数值，你要删除二叉搜索树上等于这个数值的节点，然后返回处理后的二叉搜索树。
 * 注意，二叉搜索树的节点上没有重复数值，并且要求删除节点后返回的仍然是二叉搜索树。
 * <pre>
 * 比如说，给你的二叉搜索树是：
 *
 *     1
 *    / \
 *   0   4
 *      / \
 *     2   8
 *
 * 给你的数值为 4。删掉 4 这个节点后，可以返回：
 *
 *     1
 *    / \
 *   0   2
 *        \
 *         8
 *
 * 也可以返回：
 *
 *     1
 *    / \
 *   0   8
 *      /
 *     2
 *
 * 这两个都是有效的二叉搜索树，返回其中一个即可。
 * </pre>
 */
object P092DeleteNodeInBST {
  def deleteNodeInBST(tree: TreeNode[Int], v: Int): TreeNode[Int] = {
    if (tree == null) return null

    var root = tree
    if (v < root.value) {
      root.left = deleteNodeInBST(root.left, v)
    } else if (v > root.value) {
      root.right = deleteNodeInBST(root.right, v)
    } else {
      if (root.left == null) return root.right
      else if (root.right == null) return root.left

      var leftMax = root.left
      while (leftMax.right != null) leftMax = leftMax.right

      leftMax.right = root.right
      root = root.left
    }
    root
  }
}
