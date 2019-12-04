package basic

import org.scalatest.{ FunSuite, Matchers }

class P042String2IntegerTest extends FunSuite with Matchers {
  import P042String2Integer._

  test("testToInt") {
    toInt("322") should be(322)
    toInt("-322") should be(-322)
    toInt("  -322") should be(-322)
    toInt("  -322jk") should be(-322)
    toInt("00322jk") should be(322)
    toInt("322jk43") should be(322)
    toInt("322  ") should be(322)
    toInt("23423423423423") should be(Int.MaxValue)
    toInt("-23423423423423") should be(Int.MinValue)
  }
}
