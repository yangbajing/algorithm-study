package basic

import scala.collection.mutable

/**
 * 求和为给定值的两个数
 */
object TwoNumSumIndex {
  // Time: O(n^2), Space: O(1)
  def getTwoNumSumToGivenValueBruteForce(nums: Array[Int], target: Int): Array[Int] = {
    var i = 0
    while (i < nums.length) {
      var j = i + 1
      while (j < nums.length) {
        if (nums(i) + nums(j) == target) {
          return Array(i, j)
        }
        j += 1
      }
      i += 1
    }
    Array(-1, -1)
  }

  // Time: O(n), Space: O(n)
  def getTwoNumSumToGivenValueHashMap(nums: Array[Int], target: Int): Array[Int] = {
    val map = mutable.Map[Int, Int]()

    nums.zipWithIndex.find {
      case (num, idx) =>
        val numNeeded = target - num
        map.get(numNeeded) match {
          case Some(value) =>
            true
          case _ =>
            map.put(num, idx)
            false
        }
    }

//    for ((num, idx) <- nums.zipWithIndex) {
//      val numNeeded = target - num
//      map.get(numNeeded) match {
//        case Some(value) => return Array(value, idx)
//        case _           => map.put(num, idx)
//      }
//    }

    var i = 0
    while (i < nums.length) {
      val numNeeded = target - nums(i)
      if (map.contains(numNeeded)) {
        return Array(map(numNeeded), i)
      }
      map.put(nums(i), i)
      i += 1
    }
    Array[Int](-1, -1)
  }
}
