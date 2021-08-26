package com.example.currencyconverter.miscellaneous.newactivities

import com.example.currencyconverter.miscellaneous.model.Employee
import java.util.*

class LinkedList1() {

//    var stack: LinkedList<Employee>? = LinkedList()
    var stack: LinkedList<Char>? = LinkedList()


//    fun push(employee: Employee) {
//        stack?.push(employee)
//    }

    fun push(char:Char) {
        stack?.push(char)
    }

    fun pop(): Char? {
        return stack?.pop()
    }

    fun peek(): Char? {
        return stack?.peek()
    }


    fun isEmpty(): Boolean? {
        return stack?.isEmpty()
    }

    fun print() {
        stack?.iterator()?.forEach { println(it) }
    }

}