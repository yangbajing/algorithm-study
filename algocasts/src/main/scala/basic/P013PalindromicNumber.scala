package basic

object P013PalindromicNumber {
  def isPalindromeString(x: Int): Boolean = {
    val s = x.toString
    var i = 0
    var j = s.length - 1
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) return false

      i += 1
      j -= 1
    }
    true
  }

  // Time: O(m), Space: O(1)
  def isPalindrome(x: Int): Boolean = {
    if (x < 0) return false

    var tmp = x
    var y = 0
    while (tmp != 0) {
      val num = tmp % 10
      y = y * 10 + num
      tmp = tmp / 10
      println(s"y: $y, tmp: $tmp")
    }

    y == x
  }

  def main(args: Array[String]): Unit = {
    println(isPalindromeString(1231))
    println(isPalindromeString(121))
    println(isPalindromeString(12321))
    println(Vector.fill(80)('-').mkString)
    println(isPalindrome(1231))
    println(isPalindrome(121))
    println(isPalindrome(12321))
  }
}
