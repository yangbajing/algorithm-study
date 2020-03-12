package series

/**
 * P82. 合并二叉树
 * 这个题目说的是，给你两棵二叉树，你要把它们合并起来形成一棵新的二叉树。合并规则是对应节点上的数字相加得到新节点的数字，如果有一个节点为空，
 * 则直接使用非空节点的数字，如果两个节点都为空，则合并后也为空。
 * <pre>
 * 比如说，给你的两棵二叉树是：
 *
 *     1
 *    / \
 *   3   5
 *    \   \
 *     7   9
 *
 * 和
 *
 *      2
 *     / \
 *    4   6
 *   /
 *  8
 *
 * 你要返回合并后的二叉树是：
 *
 *      3
 *     / \
 *    7   11
 *   / \    \
 *  8   7    9
 * </pre>
 */
object P082MergeTrees {
  // Time: O(min(t1.depth, t2.depth)), Space: O(n)
  def mergeTrees[T](t1: TreeNode[T], t2: TreeNode[T])(implicit ev1: Numeric[T]): TreeNode[T] = {
    if (t1 == null && t2 == null) return null
    else if (t1 == null) return t2
    else if (t2 == null) return t1

    t1.value = ev1.plus(t1.value, t2.value)
    t1.left = mergeTrees(t1.left, t2.left)
    t1.right = mergeTrees(t1.right, t2.right)
    t1
  }
}
