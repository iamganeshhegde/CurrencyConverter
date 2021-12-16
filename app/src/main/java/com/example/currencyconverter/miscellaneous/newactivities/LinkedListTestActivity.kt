package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*


class LinkedListTestActivity {
}

fun main() {
    var list = LinkedList<Int>()


    var new = reverseList(list)

}

fun reverseList(list: LinkedList<Int>) {

//    while (list.)
    reverseList(list)

}

fun kk(head:LinkedList<Int>){
//    var prevHead: LinkedList<Int>? = null
//    while (head != null) {
//        val recordNext: LinkedList<Int>? = head.next
//        head.next = prevHead
//        prevHead = head
//        head = recordNext
//    }
//    return prevHead
}


fun isValidBST(root: TreeNode?): Boolean {
    var root:TreeNode? = root ?: return true
    val stack = Stack<TreeNode>()
    var pre: TreeNode? = null
    while (root != null || !stack.isEmpty()) {
        while (root != null) {
            stack.push(root)
            root = root.left
        }
        root = stack.pop()
        if (pre != null && root.`val` <= pre.`val`) return false
        pre = root
        root = root.right
    }
    return true
}

internal class Solution(private var array: IntArray) {
    private var original: IntArray
    private val rand = Random()
    private val arrayCopy: MutableList<Int>
        private get() {
            val asList: MutableList<Int> = ArrayList()
            for (i in array.indices) {
                asList.add(array[i])
            }
            return asList
        }

    fun reset(): IntArray {
        array = original
        original = original.clone()
        return array
    }

    fun shuffle(): IntArray {
        val aux = arrayCopy
        for (i in array.indices) {
            val removeIdx = rand.nextInt(aux.size)
            array[i] = aux[removeIdx]
            aux.removeAt(removeIdx)
        }
        return array
    }

    init {
        original = array.clone()
    }


}

fun duplicateZeros(arr: IntArray) {
    var countZero = 0
    for (i in arr.indices) {
        if (arr[i] == 0) countZero++
    }
    val len = arr.size + countZero
    //We just need O(1) space if we scan from back
    //i point to the original array, j point to the new location
    var i = arr.size - 1
    var j = len - 1
    while (i < j) {
        if (arr[i] != 0) {
            if (j < arr.size) arr[j] = arr[i]
        } else {
            if (j < arr.size) arr[j] = arr[i]
            j--
            if (j < arr.size) arr[j] = arr[i] //copy twice when hit '0'
        }
        i--
        j--
    }
}



fun sortArrayByParity(A: IntArray): IntArray? {
    var i = 0
    var j = 0
    while (j < A.size) {
        if (A[j] % 2 == 0) {
            val tmp = A[i]
            A[i++] = A[j]
            A[j] = tmp
        }
        j++
    }
    return A
}
