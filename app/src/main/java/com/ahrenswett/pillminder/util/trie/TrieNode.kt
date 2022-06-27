package com.ahrenswett.pillminder.util.trie


class TrieNode<Key> (var key: Key?, var parent: TrieNode<Key>?){
    val children = mutableMapOf<Key, TrieNode<Key>>()
    var isEnd = false
}