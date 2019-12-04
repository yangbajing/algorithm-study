package basic

/**
 * P39. 判断二叉树是否平衡
 * https://algocasts.io/series/algo-problems-1-50/episodes/j5pglWx8
 * 这个题目说的是，给你一棵二叉树，你要判断它是否平衡。这里平衡指的是，对于树上任意一个节点，
 * 它的两棵子树的高度差不能大于 1。
 * <pre>
 * 比如说，给你的二叉树是：
 *
 *      1
 *    /   \
 *   2     4
 *        / \
 *       8  16
 *
 * 它的任意节点的左右子树高度差都不大于 1，因此它是一棵平衡二叉树。
 *
 * 再比如说，给你的二叉树是：
 *
 *      1
 *    /   \
 *   2     4
 *          \
 *           8
 *            \
 *            16
 *
 * 在这棵树中，根节点的左右子树高度差为 2，因此它不是一棵平衡二叉树。
 * </pre>
 */
object P039BalancedBinaryTree {
  private def getHeight[T](root: TreeNode[T]): Int = {
    if (root == null) 0
    else math.max(getHeight(root.left), getHeight(root.right)) + 1
  }

  def isBalancedBinaryTreeTopDown[T](tree: TreeNode[T]): Boolean = {
    if (tree == null) true
    else {
      math.abs(getHeight(tree.left) - getHeight(tree.right)) <= 1 &&
      isBalancedBinaryTreeTopDown(tree.left) && isBalancedBinaryTreeTopDown(tree.left)
    }
  }

  private def getHeightAndCheck[T](root: TreeNode[T]): Int = {
    if (root == null) return 0

    val left = getHeightAndCheck(root.left)
    if (left == -1) return -1

    val right = getHeightAndCheck(root.right)
    if (right == -1) return -1

    if (math.abs(left - right) > 1) -1 else math.max(left, right) + 1
  }

  def isBalancedBinaryTreeBottomUp[T](tree: TreeNode[T]): Boolean = {
    getHeightAndCheck(tree) != -1
  }
}
