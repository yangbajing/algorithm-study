package util

object StringUtils {
  @inline
  def isEmpty(s: String): Boolean = s == null || s.isEmpty

  def nonEmpty(s: String): Boolean = !isEmpty(s)

  @inline
  def isBlank(s: String): Boolean = isEmpty(s) || s.forall(_.isSpaceChar)

  def nonBlank(s: String): Boolean = !isBlank(s)
}
