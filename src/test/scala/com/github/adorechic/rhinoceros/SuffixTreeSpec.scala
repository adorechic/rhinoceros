package com.github.adorechic.rhinoceros

import org.scalatest._

class SuffixTreeSpec extends FlatSpec with Matchers {
  "SuffixTree" should "returns correct item" in {
    val tree = new SuffixTree[Int]

    tree.insert("銀座", 1)
    tree.insert("戸越銀座", 2)
    tree.insert("武蔵小杉", 3)
    tree.insert("武蔵小山", 4)

    tree.search("武蔵").toSet.shouldEqual(Set(3, 4))
    tree.search("銀座").toSet.shouldEqual(Set(1, 2))
    tree.search("越").toSet.shouldEqual(Set(2))
  }
}
