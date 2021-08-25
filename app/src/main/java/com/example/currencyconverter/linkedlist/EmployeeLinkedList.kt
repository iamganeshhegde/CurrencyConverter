package com.example.currencyconverter.linkedlist

import com.example.currencyconverter.miscellaneous.model.Employee

class EmployeeLinkedList {

    var head: EmployeeNode? = null
    var count:Int=0


    fun addToFront(employee: Employee) {
        var employeeNode = EmployeeNode(employee)
        employeeNode.next = head



        head = employeeNode
        count++

    }

    fun getSize(): Int {
        return count
    }

    fun print() {
        var employeeNode = head

        println("Head ->")
        while (employeeNode!=null) {

            println(employeeNode.toString())
            println("->")
            employeeNode = employeeNode.next
        }

        println("null")
    }


    fun removeFromFront(): EmployeeNode? {
        if(head == null) {
            return null
        }
        var removedNode = head
        head = head!!.next
        count--
        removedNode?.next = null
        return removedNode

    }
}