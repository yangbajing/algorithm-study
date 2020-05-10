package leetcode.p100

object P006ZigZagConversion {
  def convert(s: String, numRows: Int): String = {
    if (numRows < 2) return s

    val bf = new StringBuilder()
    val N = s.length
    var i = 0
    val cycleLen = 2 * numRows - 2
    while (i < numRows) {
      var j = 0
      while (j + i < N) {
        bf.addOne(s.charAt(j + i))
        val IDX = j + cycleLen - i
        if (i != 0 && i != numRows - 1 && IDX < N) {
          bf.addOne(s.charAt(IDX))
        }

        j += cycleLen
      }
      i += 1
    }
    bf.toString()
  }
}
