package algorithm

import scala.collection.mutable.ListBuffer

/**
 * @author Yang Jing <a href="mailto:yang.xunjing@qq.com">yangbajing</a>
 * @date 2020-10-28 16:38:58
 */
object Permutation {
  def permute[T](nums: Array[T]): List[List[T]] = {
    var res = List[List[T]]()
//    val track = ListBuffer[T]()

    def backtrack(track: List[T]): Unit = {
      if (track.size == nums.length) {
        res ::= track.reverse
        return
      }

      for (n <- nums if !track.contains(n)) {
        // preorder add
//        track.addOne(n)
        val items = n :: track

        // enter next
        backtrack(items)

        // postorder revoke
//        track.remove(track.size - 1)
      }
    }

    backtrack(Nil);

    res
  }

  def main(args: Array[String]): Unit = {
    permute(Array(1, 2, 3, 4)).foreach(println)
  }
}
