package basic

/**
 * P42. 字符串转整数
 * 这个题目说的是，给你一个字符串，你要把它转成一个 int 类型的数字。这个字符串里可能会包含空格，字母或是其它字符。
 * 一个可以有效地转成数字的字符串包含以下特点：
 *
 * 1. 可以有前导空格或前导 0，但不能有其它前导字符
 * 2. 可能会有一个加号或减号表示正负，也可能没有，连续的多个加号或减号则视为不合法
 * 3. 紧接着是一段连续的数字，如果没有数字则示为不合法
 * 4. 数字后的其它字符都可以忽略
 * 5. 如果数字大于 int 的最大值或小于 int 的最小值，返回相应的极值即可
 * 6. 字符串如果不能合法地转为整数，则返回 0
 */
object P042String2Integer {
  def toInt(str: String): Int = {
    if (str == null || str.isEmpty) 0
    else {
      val s = str.trim
      if (s.isEmpty) 0 else _toInt(s)
    }
  }

  private def _toInt(str: String): Int = {
    var start = 0
    var negative = false
    var p = 0
    val n = str.length

    if (str.charAt(p) == '+') {
      p += 1
    } else if (str.charAt(p) == '-') {
      p += 1
      negative = true
    }

    while (p < n && str.charAt(p) == '0') p += 1
    start = p

    while (p < n && str.charAt(p) >= '0' && str.charAt(p) <= '9') p += 1
    if (p == start) return 0

    //println(s"p: $p, start: $start, negative: $negative")
    if (p - start > 10) {
      return if (negative) Int.MinValue else Int.MaxValue
    }

    var num = 0L
    for (i <- start until p) {
      num = num * 10 + (str.charAt(i) - '0')
    }
    num = if (negative) -num else num
    //println(s"p: $p, start: $start, negative: $negative, num: $num")

    if (num < Int.MinValue) Int.MinValue else if (num > Int.MaxValue) Int.MaxValue else num.toInt
  }
}
