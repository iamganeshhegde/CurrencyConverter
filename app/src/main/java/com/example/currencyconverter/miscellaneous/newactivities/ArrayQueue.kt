package com.example.currencyconverter.miscellaneous.newactivities

import com.example.currencyconverter.b
import com.example.currencyconverter.miscellaneous.model.Employee
import java.util.*
import kotlin.NoSuchElementException

class ArrayQueue(size:Int) {

    var queue:Array<Employee?> = arrayOfNulls<Employee>(size)
    var front:Int = 0
    var back:Int = 0


    fun add(employee: Employee) {

        if(size() == queue.size -1 ) {

            var numItems = size()
            var newArray = arrayOfNulls<Employee>(2*queue.size)

            System.arraycopy(queue,front, newArray, 0, queue.size-front)
            System.arraycopy(queue,0, newArray, queue.size-front, back)

            queue = newArray


            front = 0
            back = numItems
        }

        queue[back] = employee

        if(back < queue.size -1 ) {
            back++
        } else {
            back = 0
        }


    }

    fun remove(): Employee? {

        if(size() == 0) {

            throw NoSuchElementException()

        }

       var employee = queue[front]
        queue[front] = null
        front++

        if(size() == 0) {
            front = 0
            back = 0
        } else if(front == queue.size) {
            front = 0
        }

        return employee
    }

    fun size():Int {
        if(front <= back ) {
            return back - front
        } else {
            return back - front +queue.size
        }
    }

    fun peek(): Employee? {
        if (size() == 0) {
            throw NoSuchElementException()
        }

        return queue[front]

    }

    fun print() {
        if(front <= back) {
            for (i in front until back){
                println(queue[i])
            }
        }else {
            for (i in front until queue.size) {
                println(queue[i])
            }
            for (i in 0 until back) {
                println(queue[i])
            }
        }

    }
}