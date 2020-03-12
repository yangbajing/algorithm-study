package series

/**
 * P86. 荷兰国旗问题
 * https://algocasts.io/series/algo-problems-51-100/episodes/aVWyAYW2
 * 这个题目说的是，给你一些红色/白色/蓝色的条状物，你要排序把相同颜色的放在一起，并且整体的颜色是按照红/白/蓝的顺序排列的。
 * 这三种颜色放在一起后就形成了荷兰国旗。
 * 维基百科链接：Dutch national flag problem
 * <pre>
 * 比如说，我们用 0, 1, 2 表示红/白/蓝三种颜色，给你一个包含 0, 1, 2 的整数数组：
 *
 * 2, 1, 2, 1, 0
 *
 * 你要返回排序后的结果是：
 *
 * 0, 1, 1, 2, 2
 * </pre>
 */
object P086 {
  // Time: O(n), Space: O(1)
  def sortThreeColorsCount(nums: Array[Int]): Unit = {
    var cn0 = 0
    var cn1 = 0
    var cn2 = 0
    nums.foreach {
      case 0 => cn0 += 1
      case 1 => cn1 += 1
      case 2 => cn2 += 1
    }
    var k = 0
    (0 until cn0).foreach { _ =>
      nums(k) = 0
      k += 1
    }
    (0 until cn1).foreach { _ =>
      nums(k) = 1
      k += 1
    }
    (0 until cn2).foreach { _ =>
      nums(k) = 2
      k += 1
    }
  }

  // Time: O(n), Space: O(1)
  def sortThreeColorsSwap(nums: Array[Int]): Unit = {
    var i = 0
    var k = 0
    var j = nums.length - 1
    while (k <= j) {
      nums(k) match {
        case 0 =>
          swap(nums, i, k)
          i += 1
          k += 1
        case 1 =>
          k += 1
        case _ => // 2
          swap(nums, k, j)
          j -= 1
      }
    }
  }
}
