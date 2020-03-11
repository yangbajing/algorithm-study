package series

import scala.annotation.tailrec

/**
 * P67. 二叉搜索树中查找数字
 * https://algocasts.io/series/algo-problems-51-100/episodes/VlWdg8p0
 * 这个题目说的是，给你一棵二叉搜索树和一个数字，你要在二叉搜索树上找到这个数字，并返回它所在的节点。如果找不到这个数字，就返回空指针。
 * <pre>
 * 二叉搜索树的定义是：
 *
 *   1. 左子树所有节点上的值都小于根节点上的值
 *   2. 右子树所有节点上的值都大于根节点上的值
 *   3. 左右子树同时也为二叉搜索树
 *
 * 比如说，给你的二叉搜索树是：
 *
 *      8
 *     / \
 *    2  16
 *   / \
 *  1   4
 *
 * 给你的数字是 1。1 在这棵二叉搜索树里，因此你要返回节点 1。
 *
 * 如果给你的数字是 42，不在这棵树中，则返回空指针。
 * </pre>
 */
object P067BSTSearch {
  // Time: O(n), Space: O(n)
  @tailrec
  def bstSearchRecursive[T](root: TreeNode[T], v: T)(implicit ord: Ordering[T]): TreeNode[T] = {
    if (root == null || root.value == v) root
    else if (ord.lt(v, root.value)) bstSearchRecursive(root.left, v)
    else bstSearchRecursive(root.right, v)
  }

  // Time: O(n), Space: O(1)
  def bstSearchIterative[T](root: TreeNode[T], v: T)(implicit ord: Ordering[T]): TreeNode[T] = {
    var node = root
    while (node != null && node.value != v) {
      node = if (ord.lt(v, node.value)) node.left else node.right
    }
    node
  }
}
