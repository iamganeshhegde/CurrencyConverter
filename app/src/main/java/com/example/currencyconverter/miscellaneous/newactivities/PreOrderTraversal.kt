package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*


class PreOrderTraversal {
}

fun main() {

}

fun pre() {
    var stack = Stack<Int>()

    var list = mutableListOf<Int>()
    stack.isNotEmpty()


    var toList = list.toList()

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun preorderTraversal(root: TreeNode?): List<Int>? {
    val list: MutableList<Int> = LinkedList()
    val stack: Stack<TreeNode> = Stack<TreeNode>()
    if (root != null) stack.push(root)
    while (!stack.isEmpty()) {
        val node: TreeNode = stack.pop()
        list.add(node.`val`)
        if (node.right != null) stack.push(node.right)
        if (node.left != null) stack.push(node.left)
    }
    return list
}