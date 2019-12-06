import scala.collection.mutable

package object series {
  def swap[T](arr: mutable.IndexedSeq[T], x: Int, y: Int): Unit = {
    val tmp = arr(x)
    arr(x) = arr(y)
    arr(y) = tmp
  }
}
