package basic

/**
 * P15. 缺失的数字
 * https://algocasts.io/series/algo-problems-1-50/episodes/vkmebGbP
 * 这个题目说的是，从 0 到 n 这 n+1 个整数中去掉一个，然后把剩下的 n 个整数放进一个长度为 n 的数组，给你这个数组，你要找到那个去掉的整数。
 *
 * <pre>
 * 比如说，给你的数组是：
 * 4, 1, 0, 2
 * 这里的数组长度是 4，说明这是从 0 到 4 中去掉一个数字后形成的数组。数组中缺失的数字是 3，因此我们要返回 3。
 * </pre>
 */
object P015MissingNumber {
  // Time: O(n), Space: O(1)
  def missingNumber(nums: Iterable[Int]): Int = {
    require(nums.nonEmpty)
    var result = nums.size // 最大值
    var i = 0
    val iter = nums.iterator
    while (iter.hasNext) {
      result = result ^ i ^ iter.next()
      i += 1
    }
    result
  }

  def missingNumberScala(nums: Iterable[Int]): Int = {
    require(nums.nonEmpty)
//    (nums ++ (0 to nums.size)).reduce(_ ^ _)
    nums.reduce(_ ^ _) ^ Iterator.from(0).take(nums.size + 1).reduce(_ ^ _)
  }
}
