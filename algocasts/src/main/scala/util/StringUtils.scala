package util

object StringUtils {
  @inline
  def isEmpty(s: String): Boolean = s == null || s.isEmpty

  def nonEmpty(s: String): Boolean = !isEmpty(s)

  @inline
  def isBlank(s: String): Boolean = isEmpty(s) || s.forall(_.isSpaceChar)

  def nonBlank(s: String): Boolean = !isBlank(s)

  def reverse(chars: Array[Char], start: Int, end: Int): Unit = {
    var i = start
    var j = end //chars.length - 1
    while (i < j) {
      val tmp = chars(i)
      chars(i) = chars(j)
      chars(j) = tmp
      i += 1
      j -= 1
    }
  }
}
