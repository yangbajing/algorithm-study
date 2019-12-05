package series

/**
 * P53. 相加等于 0 的三个数
 * https://algocasts.io/series/algo-problems-51-100/episodes/QrWZrbW5
 * 这个题目说的是，给你一个整数数组，你要找到数组中三个数相加等于 0 的所有可能组合。返回的答案里，每个组合都是唯一的，不能重复。
 * <pre>
 * 比如说，给你的数组是：
 *
 * -1, 0, -1, 0, 1, 0, -4
 *
 * 这个数组中有两个组合，使得三个数相加等于 0。第一个组合是：
 *
 * -1, 0, 1
 *
 * 虽然数组里有 3 个 0，两个 -1，但不管用哪个 0 或 -1，组合 -1,0,1 都只算一个。另一个有效的组合是：
 *
 * 0, 0, 0
 * </pre>
 */
object P053ThreeNumSumToZero {
  // Time: O(n^2), Space: O(1)
  def threeNumSumToZero[T](array: scala.collection.IndexedSeq[T])(implicit nums: Numeric[T]): Seq[Seq[T]] = {
    var result = List[List[T]]()
    val arr = array.sorted // 本算法排序非重点

    var k = arr.length - 1
    while (k >= 2) {
      if (nums.lt(arr(k), nums.zero)) return result

      val c = arr(k)
      val target = nums.negate(c)
      var i = 0
      var j = k - 1
      while (i < j) {
        val a = arr(i)
        val b = arr(j)
        nums.plus(a, b) match {
          case v if v == target =>
            result ::= List(a, b, c)
            while (i < j && arr(i + 1) == a) i += 1
            while (i < j && arr(j - 1) == b) j -= 1
            i += 1
            j -= 1
          case v if nums.lt(v, target) => i += 1
          case _                       => j -= 1
        }
      }

      while (k >= 2 && arr(k - 1) == c) k -= 1

      k -= 1
    }

    result
  }
}
