package series

import org.scalatest.FunSuite

import scala.collection.mutable

class P058AlgoCastsTest extends FunSuite {
  import P058AlgoCasts._
  test("array") {
    val arr = Array(1, 2, 3, 4, 5)
    shuffle(arr)
    println(java.util.Arrays.toString(arr))
  }
  test("vector") {
    val arr = mutable.ArrayBuffer(1, 2, 3, 4, 5)
    shuffle(arr)
    println(arr)
  }
}
