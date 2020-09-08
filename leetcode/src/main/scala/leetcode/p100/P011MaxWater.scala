package leetcode.p100

/**
 * @author yangbajing <a href="mailto://yang.xunjing@qq.com">羊八井</a>
 * @date 2020-09-08 20:11
 */
object P011MaxWater {
  // Time: O(N), Space: O(1)
  def maxArea(height: Array[Int]): Int = {
    var maxarea = 0
    var i = 0
    var j = height.length - 1
    while (i != j) {
      val x = height(i)
      val y = height(j)
      maxarea = Math.max(maxarea, Math.min(x, y) * (j - i))
      if (x < y) {
        i += 1
      } else {
        j -= 1
      }
    }
    maxarea
  }
}
