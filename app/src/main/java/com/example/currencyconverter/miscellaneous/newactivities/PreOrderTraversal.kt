package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*


class PreOrderTraversal {
}

fun main() {
//    deepestLeavesSum()
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


fun deepestLeavesSum(root: TreeNode?): Int {


//    val q = LinkedList<TreeNode>()

    if (root == null) {
       return 0
    }
    val queue: Queue<TreeNode?> = LinkedList()

    queue.offer(root)
    var levelSum = 0

    while ( queue.isNotEmpty()) {

        levelSum = 0

        var size = queue.size

        for (i in 0 until size) {
            var currentNode = queue.poll()
            levelSum += currentNode!!.`val`

            if(currentNode.left != null) {
                queue.add(currentNode.left)
            }

            if(currentNode.right != null) {
                queue.add(currentNode.right)
            }
        }

    }

    return levelSum

}

fun deepestLeavesSusm(root: TreeNode?): Int {
    return if (root == null) {
        0
    } else {
        var res = 0
        val q: Queue<TreeNode?> = LinkedList()
        q.offer(root)
        while (!q.isEmpty()) {
            val size = q.size
            res = 0
            for (i in 0 until size) {
                val cur = q.poll()
                res += cur!!.`val`
                if (cur.left != null) {
                    q.add(cur.left)
                }
                if (cur.right != null) {
                    q.add(cur.right)
                }
            }
        }
        res
    }

}

// 1,2,3,4,5,6

fun maxCoins(A: IntArray): Int {
    Arrays.sort(A)
    var res = 0
    val n = A.size
    var i = n / 3
    while (i < n) {
        res += A[i]
        i += 2
    }
    return res
}