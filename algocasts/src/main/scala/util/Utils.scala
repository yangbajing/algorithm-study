package util

object Utils {
  def isAlphanumeric(c: Char): Boolean =
    isBetween(c, 'a', 'z') || isBetween(c, 'A', 'Z') || isBetween(c, '0', '9')

  @inline
  def isBetween(c: Char, start: Char, end: Char): Boolean = c >= start && c <= end
}
