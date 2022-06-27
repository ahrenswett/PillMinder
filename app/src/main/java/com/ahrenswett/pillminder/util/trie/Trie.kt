package com.ahrenswett.pillminder.util.trie


class Trie<Key> (private val root: TrieNode<Key> = TrieNode<Key>( key = null, parent = null)){

   fun insert(list : List<Key>){
       var currentNode = root
       list.forEach{ key ->
           if (currentNode.children.containsKey(key)){
               currentNode = currentNode.children[key]!!
           }
           else currentNode.children[key] = TrieNode(key, currentNode)
       }
       currentNode.isEnd = true
    }

    fun contains(list : List<Key>): Boolean{
        var currentNode = root
        list.forEach{ key ->
            if (currentNode.children.containsKey(key)){
                currentNode = currentNode.children[key]!!
            }
            else return false
        }
        return true
    }

    fun getFirst5(key: Key): List<String>{
    //        builder to build each string
        val string = StringBuilder()
    //        list to append the strings to
        val listOF5 = mutableListOf<String>()
    //        current node to traverse the trie
        var currentNode = root
    //        Queue to keep track of the nodes to traverse
        val nodeQueue = mutableListOf<TrieNode<Key>>()

    //        if it contains first Key it may have more.
        if(currentNode.children.containsKey(key)){
            string.append(key)

            // store key as currentNode
            currentNode = currentNode.children[key]!!
            // if it is end of the word add to list
            if (currentNode.isEnd){
                listOF5.add(string.toString())
            }
            // get currentNode's list of children and add to Queue
            for (node in currentNode.children.keys.toList()) run { ->
                nodeQueue.add(currentNode.children[node]!!)
            }
            return if (nodeQueue.isEmpty()) listOF5
                else{
                    while (nodeQueue.isNotEmpty() && listOF5.size < 5){
                        // get first node in queue
                        currentNode = nodeQueue.removeAt(0)
                        // add key to string
                        string.append(currentNode.key)
                        // if it is end of the word add to list
                        if (currentNode.isEnd){
                            listOF5.add(string.toString())
                        }
                        // get currentNode's list of children and add to Queue
                        for (node in currentNode.children.keys.toList()) run { ->
                            nodeQueue.add(currentNode.children[node]!!)
                        }
                    }
                    return listOF5
                }
            }
            return listOF5  // if it doesn't contain first key return empty list
    }
}