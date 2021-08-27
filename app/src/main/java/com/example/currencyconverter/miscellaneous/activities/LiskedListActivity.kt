package com.example.currencyconverter.miscellaneous.activities

import com.example.currencyconverter.linkedlist.EmployeeDoublyLinkedList
import com.example.currencyconverter.linkedlist.IntegerLinkedList
import com.example.currencyconverter.miscellaneous.model.Employee


class LiskedListActivity {
}

fun main() {
    var ganesh = Employee(123, "Ganesh", "Hegde")
    var rama = (Employee(456,"Rama", "Hegde"))
    var bharati =  Employee(789,"Bharati", "Hegde")




//    var employeeLinkedList = EmployeeLinkedList()
//
//    employeeLinkedList.addToFront(ganesh)
//    employeeLinkedList.addToFront(rama)
//    employeeLinkedList.addToFront(bharati)
//
//    employeeLinkedList.print()
//
//    println(employeeLinkedList.getSize())
//
//    employeeLinkedList.removeFromFront()
//
//    println(employeeLinkedList.getSize())
//
//    employeeLinkedList.print()





    var double = EmployeeDoublyLinkedList()

//    double.addToFront(ganesh)
//    double.addToFront(rama)
//    double.addToFront(bharati)
//
//    double.print()
//    println(double.getSize())



    var newBharati =  Employee(7899,"Bharatiiii", "Hegdeeee")

//    double.addToEnd(newBharati)
//
//    double.print()
//
//    double.removeFromFront()
//
//    double.print()
//
//    double.removeFromEnd()
//
//    double.print()


//    double.addBefore(newBharati, ganesh)
//
//    double.print()
//    println(double.getSize())





//    var linkedList:LinkedList<Employee> = LinkedList()
//
//    linkedList.addFirst(ganesh)
//    linkedList.addFirst(rama)
//    linkedList.addFirst(bharati)
//
//
//
//
//
//    var employee = Employee(11111, "Bharatiiii", "hegdeeeee")
//    linkedList.add(employee)
//
//    linkedList.iterator().forEach {
//        println(it)
//    }
//
//
//    linkedList.removeFirst()
//    linkedList.removeLast()
//
//
//
//
//    linkedList.iterator().forEach {
//        println(it)
//    }
//


    val one = 1
    val two = 2
    val three = 3
    val four = 4

    val list = IntegerLinkedList()
    list.insertSorted(three)
    list.printList()
    list.insertSorted(two)
    list.printList()
    list.insertSorted(one)
    list.printList()
    list.insertSorted(four)
    list.printList()

}