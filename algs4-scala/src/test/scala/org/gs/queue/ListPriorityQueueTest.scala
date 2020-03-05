package org.gs.queue

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ListPriorityQueueTest extends AnyWordSpec with Matchers {
  "Max" should {
    "head" in {
      val q = new ListMaxPQ[Int]()
      q.enqueue(5)
      q.head shouldBe 5
    }

    "enqueue" in {
      val q = new ListMaxPQ[Int](7, 5, 3, 7)
      q.toList shouldBe List(7, 7, 5, 3)
    }

    "dequeue" in {
      val q = new ListMaxPQ[Int](7, 5, 3, 7)
      q.head shouldBe 7
      q.dequeue shouldBe Some(7)
      q.head shouldBe 7
      q.dequeue shouldBe Some(5)
      q.head shouldBe 3
    }
  }

  "Min" should {
    "head" in {
      val q = new ListMaxPQ[Int]()
      q.enqueue(5)
      q.head shouldBe 5
    }

    "enqueue" in {
      val q = new ListMaxPQ[Int](5, 5, 3, 7)
      q.toList shouldBe List(3, 5, 5, 7)
    }

    "dequeue" in {
      val q = new ListMaxPQ[Int](7, 5, 3, 7)
    }
  }
}
