package study

object CollectionUtils {
  def reverse[T](list: Iterable[T]): Seq[T] = {
    val iter = list.iterator
    var l = List.empty[T]
    while (iter.hasNext) {
      l ::= iter.next()
    }
    l
  }
}
