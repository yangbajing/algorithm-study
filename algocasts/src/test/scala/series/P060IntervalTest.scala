package series

import org.scalatest.{ FunSuite, Matchers }

class P060IntervalTest extends FunSuite with Matchers {
  import P060Interval._
  test("testMerge") {
    val coll = Array(Interval(1, 8), Interval(2, 4), Interval(9, 10), Interval(10, 16))
    val result = merge(coll)
    println(coll.mkString("[", ",", "]"))
    println(result)
  }
}
