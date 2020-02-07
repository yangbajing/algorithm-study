package leetcode.p100

object P003LongestSubStringWithoutRepeatingCharacters {
  def lengthOfLongestSubstring(s: String): Int = {
    //println(s"lengthOfLongestSubstring($s: String)")
    val buf = scala.collection.mutable.Map[Char, Int]()
    var max = 0
    var stop = s.length
    var j = 0

    while (j < stop) {
      val c = s.charAt(j)
      buf.get(c) match {
        case Some(idx) =>
          j = idx + 1
          if (j + max >= s.length) stop = j
          else buf.clear()
        case None =>
          buf.put(c, j)
          max = math.max(max, buf.size)
          //println(s"j: $j, stop: $stop, max: $max, buf: $buf")
          j += 1
      }
    }
    max
  }
}
