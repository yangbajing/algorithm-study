package basic

import java.util.Objects

import scala.collection.mutable

/**
 * P24. 实现 LRU 缓存
 * https://algocasts.io/series/algo-problems-1-50/episodes/rLmP8moY
 * 这个题目说的是，你要实现一个 LRU 缓存，提供 get 和 put 两个操作，并且要求两个操作的时间复杂度都是 O(1)。
 */
object P024LRUCache {
  class LRUCache[K, V](capacity: Int) {
    private class Node(val key: K, val value: V, var prev: Node, var next: Node)

    private val map = mutable.Map.empty[K, Node]
    private var head: Node = _
    private var _size = 0

    def top: Option[V] = if (head == null) None else Some(head.value)

    def get(key: K): Option[V] = {
      map.get(key).map { node =>
        move2Head(node)
        node.value
      }
    }

    def put(key: K, value: V): Option[V] = {
      if (!map.contains(key) && _size == capacity) { // capacity is full
        None
      } else {
        val node = new Node(key, value, null, null)
        val old = map.put(key, node).map { node =>
          detach(node)
          node.value
        }
        move2Head(node)
        if (old.isEmpty) {
          _size += 1
        }
        old
      }
    }

    def remove(key: K): Option[V] = {
      map.get(key).foreach { node =>
        _size -= 1
        if (_size == 0) {
          head = null
        } else if (node == head) {
          head = node.next
        }
        detach(node)
      }
      map.remove(key).map(_.value)
    }

    def size: Int = _size

    private def move2Head(node: Node): Unit = {
      if (Objects.isNull(head)) {
        head = node
        head.prev = node
        head.next = node
      } else {
        detach(node)
        attach(node)
      }
    }

    private def attach(node: Node): Unit = {
      if (Objects.nonNull(head.prev)) {
        head.prev.next = node
        node.prev = head.prev
      }
      if (Objects.nonNull(head.next)) {
        head.next.prev = node
        node.next = head.next
      }
      head = node
    }

    private def detach(node: Node): Unit = {
      if (Objects.nonNull(node.prev)) {
        node.prev.next = node.next
      }
      if (Objects.nonNull(node.next)) {
        node.next.prev = node.prev
      }
    }
  }
}
