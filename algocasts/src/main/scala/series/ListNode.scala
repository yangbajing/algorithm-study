package series

final class ListNode[T](var value: T, var next: ListNode[T] = null)
object ListNode {
  def apply[T](value: T, next: ListNode[T] = null): ListNode[T] = new ListNode[T](value, next)
  def create[T](items: T*): ListNode[T] = {
    val dummy = new ListNode(null.asInstanceOf[T])
    var node = dummy
    for (v <- items) {
      node.next = new ListNode(v)
      node = node.next
    }
    dummy.next
  }

  def equals[T](first: ListNode[T], second: ListNode[T]): Boolean = {
    var x = first
    var y = second
    while (x != null && y != null) {
      if (x.value != y.value) return false

      x = x.next
      y = y.next
    }
    if (x != null || y != null) false else true
  }
}
