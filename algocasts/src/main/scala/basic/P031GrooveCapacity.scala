package basic

/**
 * P31. 容纳最多水的凹槽容量
 * https://algocasts.io/series/algo-problems-1-50/episodes/k8GNameQ
 * 这个题目说的是，给你一个非负整数数组，数组中的数字表示高度值，在平面坐标画出来后，连同 X 轴一起，会形成许多的凹槽。
 * 你要找到两个高度值，使其形成的凹槽所能容纳的水最多。最后返回容纳的水量。
 */
object P031GrooveCapacity {
  def maxWater(height: scala.collection.IndexedSeq[Int]): Int = {
    var max = 0
    var i = 0
    var j = height.length - 1
    while (i < j) {
      val cur = math.min(height(i), height(j)) * (j - i)
      max = math.max(cur, max)
      if (height(i) < height(j)) i += 1 else j -= 1
    }
    max
  }
}
