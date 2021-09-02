package com.example.currencyconverter.miscellaneous.newactivities

import com.example.currencyconverter.miscellaneous.model.Employee
import java.util.*
import kotlin.math.absoluteValue

class HashtableChallenge {
}

fun main() {

    // challenge to create a hash function


//    var newArray = IntArray(10) {
//        0
//    }
//
//    var array = arrayOfNulls<Int>(10)
//
//    var numToAdd = arrayOf(59382, 43, 6894, 500, 99, -58)
//
//    for (i in 0 until numToAdd.size){
//
//        array[hashh(numToAdd[i])] = numToAdd[i]
//    }
//
//    for (i in 0 until array.size) {
//        println(array[i])
//        println("${newArray[i]}  neew array")
//    }




//    Remove duplicates from a linked list using map

    var ganesh = Employee(123, "Ganesh", "Hegde")
    var rama = (Employee(456,"Rama", "Hegde"))
    var bharati =  Employee(789,"Bharati", "Hegde")


    var ganess = Employee(123, "ganess", "Hegde")


    var linkedList = LinkedList<Employee>()

    linkedList.add(rama)
    linkedList.add(ganesh)
    linkedList.add(bharati)
    linkedList.add(rama)
    linkedList.add(ganesh)


    linkedList.iterator().forEach {
        println(it)
    }


    var map = mutableMapOf<Int,Employee>()

    for (i in 0 until linkedList.size) {
        map.put(linkedList[i].id, linkedList[i])
    }

    println()
    map.iterator().forEach {
        println(it)
    }


}

fun hashh(num:Int): Int {


    return (num % 10).absoluteValue
}