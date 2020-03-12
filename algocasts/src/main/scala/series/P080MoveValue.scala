package series
import scala.collection.mutable

/**
 * P80. 向后移动 0
 * https://algocasts.io/series/algo-problems-51-100/episodes/BPp65lGr
 * 这个题目说的是，给你一个整数数组，你要把数组中的 0 都移动到数组末端，同时还要保持非 0 元素的相对位置不变。另外，操作直接在原数组上进行即可。
 * <pre>
 * 比如说，给你的数组是：
 *
 * 0, 1, 2, 0, 4
 *
 * 把 0 都移动到数组末端，得到的数组是：
 *
 * 1, 2, 4, 0, 0
 *
 * 注意，这里 1,2,4 保持了它们在原来数组中的相对顺序。
 * </pre>
 */
object P080MoveValue {
  // Time: O(n), Space: O(1)
  def moveValueSwap[T](nums: mutable.IndexedSeq[T], v: T): Unit = {
    if (nums == null || nums.length < 2) return

    var slow = 0
    for (fast <- nums.indices if nums(fast) != v) {
      val tmp = nums(slow)
      nums(slow) = nums(fast)
      nums(fast) = tmp
      slow += 1
    }
  }
}
