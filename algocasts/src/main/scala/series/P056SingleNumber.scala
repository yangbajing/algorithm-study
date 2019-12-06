package series

/**
 * P56. 有序数组中的单身数字
 * https://algocasts.io/series/algo-problems-51-100/episodes/dbGY42m5
 * 这个题目说的是，给你一个排好序的整数数组，里面的数字都出现两次，只有一个数字出现了一次，我们管它叫单身数字，你要写代码找到这个单身数字。
 * <pre>
 * 比如说给你的有序数组是：
 *
 * 1, 1, 2, 2, 4, 4, 6, 8, 8
 *
 * 这个数组里 6 只出现了一次，因此你要返回的数字就是 6。
 * </pre>
 */
object P056SingleNumber {
  // Time: O(n), Space: O(1)
  def singleNumberXOR(list: Iterable[Int]): Int = {
    list.fold(0)(_ ^ _)
  }

  // Time: O(log(n)), Space: O(1)
  def singleNumberSearch[T](arr: scala.collection.IndexedSeq[T]): Option[T] = {
    val N = arr.length
    var low = 0
    var high = arr.length - 1
    while (low <= high) {
      var mid = low + (high - low) / 2
      val cur = arr(mid)
      if (mid > 0 && cur == arr(mid - 1)) {
        mid -= 1
      } else if (mid + 1 < N && cur == arr(mid + 1)) {
        // do nothing
      } else return Some(cur)
      if ((mid - low) % 2 == 0) low = mid + 2 else high = mid - 1
    }
    None
  }
}
