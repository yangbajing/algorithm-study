package study.algs4

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CompressQuickUnionUFTest extends AnyWordSpec with Matchers {
  "CompressQuickUnionUF" should {
    "N is 10" in {
      val uf = new CompressQuickUnionUF(10)
      val data = Seq((4, 3), (3, 8), (6, 5), (9, 4), (2, 1), (8, 9), (5, 0), (7, 2), (6, 1), (1, 0), (6, 7))
      for ((p, q) <- data) {
        uf.union(p, q)
      }

      //      0, 1, 2, 3, 4, 5, 6, 7, 8, 9
      // List(6, 6, 6, 4, 4, 6, 6, 6, 4, 4) compressed
      // List(6, 2, 6, 4, 4, 6, 6, 2, 4, 4)
      println("N is 10 " + uf.id.toList)
    }
    "N is 10-2" in {
      val uf = new CompressQuickUnionUF(8)
      val data = Seq((0, 1), (2, 3), (4, 5), (6, 7), (0, 2), (4, 6), (0, 4))
      for ((p, q) <- data) {
        uf.union(p, q)
      }

      //      0, 1, 2, 3, 4, 5, 6, 7)
      // List(0, 0, 0, 2, 0, 4, 4, 6) compressed
      // List(0, 0, 0, 2, 0, 4, 4, 6)
      println("N is 10-2 " + uf.id.toList)
    }
  }
}
