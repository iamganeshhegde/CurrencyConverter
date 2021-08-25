package com.example.currencyconverter.linkedlist

class IntegerLinkedList {

    private var head: IntegerNode? = null
    private var size = 0

    fun addToFront(value: Int) {
        val node = IntegerNode(value)
        node.value = value
        node.next = head
        head = node
        size++
    }

    fun removeFromFront(): IntegerNode? {
        if (isEmpty()) {
            return null
        }
        val removedNode = head
        head = head!!.next
        size--
        removedNode!!.next = null
        return removedNode
    }

    fun insertSorted(value: Int) {

//        // add your code here
//
        var intNode = IntegerNode(value)

        if(head == null || head!!.value!! >= value) {
            addToFront(value)
            return
        }

        var current = head!!.next
        var left = head

        while (current != null && value > current.value!!) {
            left = current
            current = current.next

        }

        left?.next = intNode
       intNode?.next = current
        size++
//
//
//         assumption: the list is sorted

//         assumption: the list is sorted
//        if (head == null || head!!.value!! >= value) {
//            addToFront(value)
//            return
//        }
//
//         find the insertion point
//
//         find the insertion point
//        var current = head!!.next
//        var previous: IntegerNode = head as IntegerNode
//        while (current != null && current.value!! < value) {
//            previous = current
//            current = current.next
//        }
//
//        val newNode = IntegerNode(value)
//        newNode.next = current
//        previous.next = newNode
//
//        size++
//


    }

    fun getSize(): Int {
        return size
    }

    fun isEmpty(): Boolean {
        return head == null
    }

    fun printList() {
        var current = head
        print("HEAD -> ")
        while (current != null) {
            print(current)
            print(" -> ")
            current = current.next
        }
        println("null")
    }
}