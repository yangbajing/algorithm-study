package basic

import java.util.Objects

object P016BinaryTreeMinDepth {
  def minDepth(tree: TreeNode): Int = {
    if (Objects.isNull(tree)) 0
    else if (Objects.isNull(tree.left) && Objects.isNull(tree.right)) 1
    else if (Objects.isNull(tree.left)) minDepth(tree.right) + 1
    else if (Objects.isNull(tree.right)) minDepth(tree.left) + 1
    else Math.min(minDepth(tree.left), minDepth(tree.right)) + 1
  }
}
