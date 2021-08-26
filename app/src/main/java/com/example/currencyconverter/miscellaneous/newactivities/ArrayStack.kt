package com.example.currencyconverter.miscellaneous.newactivities

import com.example.currencyconverter.miscellaneous.model.Employee
import java.util.*

class ArrayStack(capacity:Int) {


    private var stack: Array<Employee?> = arrayOfNulls<Employee>(capacity)
    private var top:Int =0





    fun push(employee: Employee) {
        if(top == stack.size) {
//need to resize

            var newArray = arrayOfNulls<Employee>(2*stack.size)
            System.arraycopy(stack,0,newArray,0,stack.size)

            stack = newArray
        }

        stack[top++] = employee
    }

    fun pop(): Employee? {
        if(isEmpty()) {
            throw EmptyStackException()
        }

        var employee = stack[--top]


        return employee

    }


    fun peek(): Employee? {

        if(isEmpty()) {
            throw EmptyStackException()
        }

        var employee = stack[top - 1]

        return employee

    }

    fun size(): Int {
        return top
    }


    fun print() {
        for(i in top-1 downTo 0) {

            println(stack[i])

        }
    }

    fun isEmpty(): Boolean {
        return top == 0
    }

}