package basic

import scala.collection.mutable

object P033LevelOrderTraversal {
  def levelOrderTraversal[T](tree: TreeNode[T]): Seq[Seq[T]] = {
    val queue = mutable.Queue[TreeNode[T]](tree)
    var results = Vector[Seq[T]]()
    while (queue.nonEmpty) {
      results :+= queue.indices.map { _ =>
        val node = queue.dequeue()
        if (node.left != null) queue.enqueue(node.left)
        if (node.right != null) queue.enqueue(node.right)
        node.value
      }
    }
    results
  }
}
