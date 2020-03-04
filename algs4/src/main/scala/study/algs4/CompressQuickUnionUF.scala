package study.algs4

class CompressQuickUnionUF(N: Int) {
  private var _count = N
  val id: Array[Int] = (0 until N).toArray
  val weights: Array[Int] = id.map(_ => 1)

  def root(n: Int): Int = {
    var p = n
    while (p != id(p)) { p = id(p) }

    var i = n
    while (i != id(i)) {
      val j = i
      i = id(i)
      id(j) = p
    }
    id(i) = p

    p
  }

  def connected(p: Int, q: Int): Boolean = root(p) == root(q)

  def union(p: Int, q: Int): Unit = {
    val pRoot = root(p)
    val qRoot = root(q)
    if (pRoot != qRoot) {
      val pSize = weights(pRoot)
      val qSize = weights(qRoot)
      println(s"($p, $q), ($pRoot, $qRoot)")
      if (pSize < qSize) {
        id(pRoot) = qRoot
        weights(qRoot) += weights(pRoot)
//        compress(p, qRoot)
      } else {
        id(qRoot) = pRoot
        weights(pRoot) += weights(qRoot)
//        compress(q, pRoot)
      }
      _count -= 1
    } else {
      println(s"($p, $q), Ignore.")
    }
  }

  def compress(n: Int, root: Int): Unit = {
    var p = n
    while (p != root && p != id(p)) {
      val j = p
      p = id(p)
      id(j) = root
    }
    id(p) = root
  }

  def count: Int = _count
}
