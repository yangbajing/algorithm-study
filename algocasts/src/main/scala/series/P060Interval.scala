package series

/**
 * P60. 区间合并
 * https://algocasts.io/series/algo-problems-51-100/episodes/kVG9AYGg
 * 这个题目说的是，给你一个区间集合，你要把有重叠的区间合并起来。
 * <pre>
 * 比如说，给你的区间集合是：
 *
 * [1, 8]
 * [2, 4]
 * [9, 10]
 * [10, 16]
 *
 * 这 4 个区间里，[1, 8] 区间包含了 [2, 4] 区间，于是它们合并后是 [1, 8]。
 *
 * [9, 10] 区间和 [10, 16] 区间相邻，合并起来后是 [9, 16]。最后得到合并后的区间有两个：
 *
 * [1, 8]
 * [9, 16]
 * </pre>
 */
object P060Interval {
  case class Interval(start: Int, end: Int)

  // Time: O(n*log(n)), Space: O(1)
  def merge(intervals: collection.Seq[Interval]): Seq[Interval] = {
    val sorted = intervals.sortWith(_.start < _.start)
    sorted.view.tail.foldLeft(Vector(sorted.head)) { (vecs, cur) =>
      val init :+ last = vecs
      if (last.end < cur.start) vecs :+ cur
      else init :+ last.copy(end = math.max(last.end, cur.end))
    }
  }
}
