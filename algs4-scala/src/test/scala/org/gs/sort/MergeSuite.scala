package org.gs.sort

import org.gs.fixtures.WordArrayBuilder
import org.scalatest.FlatSpec

/** ScalaTest for Merge
 * @see [[https://algs4.cs.princeton.edu/51radix/shells.txt]]
 *
 * @author Gary Struthers
 */
class MergeSuite extends FlatSpec {
  behavior of "a Merge"

  it should "sort strings" in new WordArrayBuilder {
//    val managedResource = readURI("https://algs4.cs.princeton.edu/51radix/shells.txt")
//    val strings = managedResource.loan(readFileToArray).toList
    val strings = List(
      "she",
      "sells",
      "seashells",
      "by",
      "the",
      "sea",
      "shore",
      "the",
      "shells",
      "she",
      "sells",
      "are",
      "surely",
      "seashells")
    println(s"strings is $strings")
    val sorted: List[String] = Merge.msort[String](strings)
    println(s"sorted is $sorted")
    assert(sorted.head === "are")
    assert(sorted(strings.length - 1) === "the")
  }
}
