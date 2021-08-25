package com.example.currencyconverter.linkedlist

import com.example.currencyconverter.miscellaneous.model.Employee

class EmployeeDoublyLinkedList {

    var head: EmployeeNode? = null
    var count: Int = 0
    var tail: EmployeeNode? = null


    fun addToFront(employee: Employee) {
        var employeeNode = EmployeeNode(employee)
        employeeNode.next = head

        if (head == null) {
            tail = employeeNode
        } else {
            head!!.previous = employeeNode
        }
        head = employeeNode
        count++

    }


    fun addToEnd(employee: Employee) {
        var employeeNode = EmployeeNode(employee)

        if (tail == null) {
            head = employeeNode
        } else {
            tail!!.next = employeeNode
            employeeNode.previous = tail
        }
        tail = employeeNode
        count++

    }


    fun addBefore(newEmployee:Employee, employee: Employee) {

        var temp = this.head
        var newemployeeNode = EmployeeNode(newEmployee)

        var oldEmployeeNode = EmployeeNode(employee)

        while (temp != null && temp.employee.equals(employee)) {
            temp = temp.next
        }

            if(temp == null) {

                return
            }



        newemployeeNode.previous = temp.previous
        newemployeeNode.next = temp

        temp.previous = newemployeeNode

        if(head == temp) {
            head = newemployeeNode
            count++

        }else {
            newemployeeNode.previous?.next = temp
            count++

        }



//                temp!!.next!!.previous = newemployeeNode
//
//                temp!!.next = newemployeeNode
//                newemployeeNode.previous = temp
//
//                return
//            }
//            temp= temp!!.next
//        }



//        if (tail == null) {
//            head = employeeNode
//        } else {
//            tail!!.next = employeeNode
//            employeeNode.previous = tail
//        }
//        tail = newemployeeNode
//        count++

    }

    fun getSize(): Int {
        return count
    }

    fun print() {
        var employeeNode = head

        println("Head ->")
        while (employeeNode != null) {

            println(employeeNode.toString())
            println("<->")
            employeeNode = employeeNode.next
        }

        println("null")
    }


    fun removeFromFront(): EmployeeNode? {
        if (head == null) {
            return null
        }

        if (head!!.next == null) {
            tail = null
        } else {
            head!!.next?.previous = null
        }


        var removedNode = head
        head = head!!.next
        count--
        removedNode?.next = null
        return removedNode

    }


    fun removeFromEnd(): EmployeeNode? {

        if(tail == null) {
            return null
        }
        if(tail!!.previous == null) {
            head = null
        } else {
            tail!!.previous?.next = null
        }

        var removedNode = tail
        tail = tail!!.previous

        count--

        return removedNode

    }
}