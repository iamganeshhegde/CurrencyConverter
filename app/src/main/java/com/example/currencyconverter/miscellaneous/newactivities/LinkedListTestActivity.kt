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