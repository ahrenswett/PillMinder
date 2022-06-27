package com.ahrenswett.pillminder.util.trie

import dagger.hilt.internal.definecomponent.DefineComponentNoParent

class TrieNode<Key> (var key: Key, var parent: TrieNode<Key>?){
    val children = mutableMapOf<Key, TrieNode<Key>>()
    var isEnd = false
}