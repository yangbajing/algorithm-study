package series

case class ListNode[T](var value: T, var next: ListNode[T] = null)
object ListNode {
  def create[T](items: T*): ListNode[T] = {
    val dummy = ListNode(null.asInstanceOf[T])
    var node = dummy
    for (v <- items) {
      node.next = ListNode(v)
      node = node.next
    }
    dummy.next
  }
}
