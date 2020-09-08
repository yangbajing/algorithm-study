package leetcode.p200

import scala.collection.mutable

/**
 * @author yangbajing <a href="mailto://yang.xunjing@qq.com">羊八井</a>
 * @since 2020-09-08 20:50
 */
object P144PreorderTraversal {
  // Time: O(N), Space: O(N)
  def preorderTraversal(root: TreeNode): List[Int] = {
    var output = List[Int]()
    var node = root
    while (node != null) {
      if (node.left == null) {
        output ::= node.value
        node = node.right
      } else {
        var pre = node.left
        while (pre.right != null && pre.right != node) {
          pre = pre.right
        }
        if (pre.right == null) {
          output ::= node.value
          pre.right = node
          node = node.left
        } else {
          pre.right = null
          node = node.right
        }
      }
    }
    output.reverse
  }

  // Time: O(N), Space: O(N)
  def preorderTraversalWithRecursive(tree: TreeNode): List[Int] = {
    val arr = mutable.Buffer[Int]()
    preorderTraversal(arr, tree)
    arr.toList
  }

  private def preorderTraversal(arr: mutable.Buffer[Int], node: TreeNode): Unit = {
    if (node != null) {
      arr.addOne(node.value)
      if (node.left != null) preorderTraversal(arr, node.left)
      if (node.right != null) preorderTraversal(arr, node.right)
    }
  }

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }
}
