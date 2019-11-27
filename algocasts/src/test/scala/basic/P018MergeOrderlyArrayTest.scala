package basic

import org.scalatest.{ FunSuite, Matchers }

import scala.collection.mutable

class P018MergeOrderlyArrayTest extends FunSuite with Matchers {
  import P018MergeOrderlyArray._
  test("testMergeOrderly") {
    mergeOrderly(Array(1, 4, 7, 9), IndexedSeq(2, 3, 5, 11, 12)) should ===(Vector(1, 2, 3, 4, 5, 7, 9, 11, 12))
    mergeOrderly(Vector(1.3, 4.1, 7.7, 9.9, 14.8, 18.5, 22.3), mutable.ArrayBuffer(2.2, 5.5, 11.6, 17.4)) should ===(
      Array(1.3, 2.2, 4.1, 5.5, 7.7, 9.9, 11.6, 14.8, 17.4, 18.5, 22.3))
  }
}
