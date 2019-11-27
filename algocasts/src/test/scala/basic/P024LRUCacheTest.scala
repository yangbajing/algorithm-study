package basic

import org.scalatest.{ FunSuite, Matchers }

class P024LRUCacheTest extends FunSuite with Matchers {
  import P024LRUCache._

  test("LRUCache") {
    val cache = new LRUCache[Int, Int](4)
    cache.top should ===(None)

    cache.put(1, 1) should ===(None)
    cache.top should ===(Some(1))

    cache.put(2, 2) should ===(None)
    cache.top should ===(Some(2))
    cache.size should ===(2)

    cache.put(3, 3) should ===(None)
    cache.top should ===(Some(3))
    cache.top should ===(Some(3))

    cache.put(4, 4) should ===(None)
    cache.top should ===(Some(4))
    cache.size should ===(4)

    cache.put(5, 5) should ===(None)
    cache.size should ===(4)

    cache.put(3, 33) should ===(Some(3))
    cache.size should ===(4)
    cache.top should ===(Some(33))

    cache.remove(5) should ===(None)
    cache.size should ===(4)

    cache.remove(3) should ===(Some(33))
    cache.size should ===(3)
    cache.top should ===(Some(4))

    cache.get(1) should ===(Some(1))
    cache.top should ===(Some(1))

    cache.remove(1)
    cache.size should ===(2)
    cache.top should ===(Some(4))

    cache.remove(2)
    cache.size should ===(1)
    cache.top should ===(Some(4))

    cache.remove(4)
    cache.top should ===(None)
    cache.size should ===(0)

    cache.remove(9)
    cache.top should ===(None)
    cache.size should ===(0)
  }
}
