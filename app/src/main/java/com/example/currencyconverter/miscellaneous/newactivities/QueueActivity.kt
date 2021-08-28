package com.example.currencyconverter.miscellaneous.newactivities

import com.example.currencyconverter.miscellaneous.model.Employee

class QueueActivity {


}

fun main() {

    var ganesh = Employee(123, "Ganesh", "Hegde")
    var rama = (Employee(456,"Rama", "Hegde"))
    var bharati =  Employee(789,"Bharati", "Hegde")


    var queue = ArrayQueue(5);

    queue.add(ganesh)
    queue.add(rama)
    queue.add(bharati)

    queue.remove()

    queue.add(rama)
    queue.remove()

    queue.add(rama)
    queue.remove()
    queue.add(ganesh)

    queue.remove()
    queue.add(ganesh)


    queue.print()




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

}