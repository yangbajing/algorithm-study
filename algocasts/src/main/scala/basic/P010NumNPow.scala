package basic

object P010NumNPow {
  // Time: O(n), Space: O(1)
  def pow(x: Double, n: Int): Double = {
    var result = 1.0d
    val N = Math.abs(n.toLong)
    var i = 0
    while (i < N) {
      result *= x
      i += 1
    }
    println(s"pow i is $i")
    if (n < 0) 1 / result else result
  }

  // Time: O(log(n)), Space: O(1)
  def powFast(x: Double, n: Int): Double = {
    var index = x
    var result = 1.0d
    var N = Math.abs(n.toLong)
    var i = 0
    while (N != 0) {
      if ((N & 1) == 1) {
        result *= index
        println(s"($N & 1): ${N & 1}, x: $index, result: $result")
      } else {
        println(s"($N & 1): 0, x: $index, result: $result")
      }
      index *= index
      N >>= 1
      i += 1
    }
    println(s"powFast i is $i")
    if (n < 0) 1 / result else result
  }

  def main(args: Array[String]): Unit = {
    val a = pow(2, 32)
    val b = powFast(2, 32)
    println(s"a: $a, b: $b")
  }
}
