package leetcode.p500

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @date 2020-10-23 14:41:06
 */
class P528RandomPickWithWeightTest extends AnyWordSpec with Matchers {
  "Random pick with weight" should {
    "1 3" in {
      val obj = new P528RandomPickWithWeight(Array(1, 3))
      val list = (0 until 32).map(_ => obj.pickIndex())
      println(list)
    }
  }
}
