package com.example.currencyconverter.miscellaneous.newactivities

import com.example.currencyconverter.miscellaneous.model.Employee
import java.util.*

class QueueActivity {


}

fun main() {

    var ganesh = Employee(123, "Ganesh", "Hegde")
    var rama = (Employee(456,"Rama", "Hegde"))
    var bharati =  Employee(789,"Bharati", "Hegde")


//    var queue = ArrayQueue(5);
//
//    queue.add(ganesh)
//    queue.add(rama)
//    queue.add(bharati)
//
//    queue.remove()
//
//    queue.add(rama)
//    queue.remove()
//
//    queue.add(rama)
//    queue.remove()
//    queue.add(ganesh)
//
//    queue.remove()
//    queue.add(ganesh)
//
//
//    queue.print()




//
//    queue.add(ganesh)
//    queue.add(ganesh)
//    queue.add(ganesh)
//    queue.add(ganesh)
//    queue.add(ganesh)
//    queue.add(rama)
//
//    queue.remove()
//    queue.remove()
//    queue.remove()
//    queue.remove()
//    queue.remove()
//
//    println(queue.peek())





    var string = "racecara"
    var stack:LinkedList<Char> = LinkedList()
    var queue:LinkedList<Char> = LinkedList()



    for (i in string.indices) {
        stack.push(string.get(i))
        queue.addLast(string.get(i))
    }

    for (i in 0 until stack.size) {

        if(stack.pop() != queue.removeFirst()) {
            println("false")
        }
        println("true")

    }









}