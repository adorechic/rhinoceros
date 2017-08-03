package com.github.adorechic.rhinoceros

import org.trie4j.MapTrie
import org.trie4j.patricia.MapPatriciaTrie

import scala.collection.JavaConverters._

class SuffixTree[T] {
  val trie: MapTrie[List[T]] = new MapPatriciaTrie[List[T]]

  def insert(key: String, target: T) = {
    val list = List(target)
    Range(0, key.length).map(i => key.takeRight(i)).foreach(suffix => {
      val previous = trie.insert(suffix, list)
      if (previous != null && previous != list) {
        trie.insert(suffix, previous ++ list)
      }
    })
  }

  def search(word: String): List[T] = {
    trie.predictiveSearchEntries(word).asScala.map(_.getValue).toList.flatten
  }
}
