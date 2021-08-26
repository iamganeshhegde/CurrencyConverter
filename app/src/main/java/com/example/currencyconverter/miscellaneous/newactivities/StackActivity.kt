package com.example.currencyconverter.miscellaneous.newactivities

import com.example.currencyconverter.miscellaneous.model.Employee
import java.util.*

class StackActivity {


}

fun main() {

//    var array = intArrayOf(1,2,3,4)
//
//    var newArray = IntArray(10)
//
//
////    var copyOf = array.copyOf(newArray.size)
//
//    System.arraycopy(array, 0, newArray,0,array.size)
//
//    (newArray.iterator().forEach { println(it) })



//    var stack = ArrayStack(10)
//
//    stack.push(Employee(111,"Ganesh", "Hegde"))
//    stack.push(Employee(123,"Rama", "Hegde"))
//    stack.push(Employee(1234,"Bharati", "Hegde"))
//
//    stack.print()
//
//    println(stack.peek().toString())
//
//
//    println(stack.pop())
//
//    stack.print()
//
//    println(stack.size())






    var ganesh = Employee(123, "Ganesh", "Hegde")
    var rama = (Employee(456,"Rama", "Hegde"))
    var bharati =  Employee(789,"Bharati", "Hegde")



//    var linkedList1:LinkedList1 = LinkedList1()
//
//    linkedList1.push(ganesh)
//    linkedList1.push(rama)
//    linkedList1.push(bharati)
//
//
//    linkedList1.print()
//
//    println(linkedList1.pop())
//
//
//    println(linkedList1.pop())
//    println()
//
//    linkedList1.print()

    var string = "radcar"

    var link = LinkedList1()
    var i = 0
    var j =string.length -1

    var mid = string.length /2

    while (i < mid && j >= mid) {

        if(string.get(i) == string.get(j)){
            i++
            j--
        } else {
            println("not Palindrome")
            return
        }

        println("Palindrome")

    }


    var builder = StringBuilder()
    builder.replace(" ","")




}


fun arrayStack() {

}