package basic

/**
 * P30. 编辑距离
 * https://algocasts.io/series/algo-problems-1-50/episodes/D1mRjmzE
 * 这个题目说的是，给你两个字符串，你要求出由其中一个字符串转成另一个所需要的最少编辑操作次数。
 * 允许的操作有 3 种，分别是：替换一个字符，插入一个字符和删除一个字符。
 * <pre>
 * 比如说，给你的两个字符串是 car 和 ba。
 *
 * s1: car
 * s2: ba
 *
 * 你要把 car 转成 ba，需要先把 c 替换成 b，然后再删除 r。总共操作 2 次，因此它们的编辑距离是 2。
 * </pre>
 */
object P030EditDistance {
  def editDistance(s: String, t: String): Int = {
    require(s != null)
    require(t != null)

    val m = s.length + 1
    val n = t.length + 1
    val d = Array.ofDim[Int](m, n)
    (0 until m).foreach(i => d(i)(0) = i)
    (0 until n).foreach(j => d(0)(j) = j)
    dumpArray(d)

    for {
      i <- 1 until m
      j <- 1 until n
    } {
      d(i)(j) =
        if (s.charAt(i - 1) == t.charAt(j - 1)) d(i - 1)(j - 1)
        else min(d(i - 1)(j - 1), d(i - 1)(j), d(i)(j - 1)) + 1
      dumpArray(d)
    }

    d(m - 1)(n - 1)
  }

  def editDistance1dArray(s: String, t: String): Int = {
    require(s != null)
    require(t != null)

    val m = s.length + 1
    val n = t.length + 1
    val d = Array.ofDim[Int](n)
    (0 until n).foreach(j => d(j) = j)
    dumpArray(d)

    (1 until m).foreach { i =>
      var pre = d(0)
      d(0) = i
      (1 until n).foreach { j =>
        val ppre = pre
        val tmp = d(j)
        d(j) = if (s.charAt(i - 1) == t.charAt(j - 1)) pre else min(pre, d(j), d(j - 1)) + 1
        pre = tmp
        println(s"i:$i,j:$j, ${s.charAt(i - 1)} == ${t.charAt(j - 1)} pre:$ppre ${d.mkString("[", ",", "]")}")
      }
    }
    d(n - 1)
  }

  private def dumpArray[T](arr: Array[T]): Unit = {
    println
    println(arr.mkString("[", ",", "]"))
  }
  private def dumpArray[T](d: Array[Array[T]]): Unit = {
    println
    d.foreach(arr => println(arr.mkString("[", ",", "]")))
  }

  private def min(a: Int, b: Int, c: Int): Int = math.min(a, math.min(b, c))
}
