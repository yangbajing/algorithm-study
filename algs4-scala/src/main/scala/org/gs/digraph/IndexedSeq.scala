package org.gs.digraph

import scala.annotation.tailrec

class IndexedSeq[+A] extends scala.collection.IndexedSeq[A] {
  override def apply(i: Int): A = ???

  override def length: Int = ???

  override def foldLeft[B](z: B)(op: (B, A) => B): B = {
    @inline @tailrec def inner(acc: B, n: Int): B =
      if (n == length) acc
      else inner(op(acc, apply(n)), n + 1)

    inner(z, 0)
  }

  override def foldRight[B](z: B)(op: (A, B) => B): B = {
    @inline @tailrec def inner(acc: B, n: Int): B =
      if (n == 0) acc
      else inner(op(apply(n), acc), n - 1)

    inner(z, length)
  }
}
