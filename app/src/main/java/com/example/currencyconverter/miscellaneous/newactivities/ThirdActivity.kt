package com.example.currencyconverter.miscellaneous.newactivities

import com.example.currencyconverter.miscellaneous.model.Employee
import java.util.*

internal class ThirdActivity {

}

fun main() {

    var employeeList = Vector<Employee>()

    employeeList.add(Employee(123,"Ganesh", "Hegde"))
    employeeList.add(Employee(456,"Rama", "Hegde"))
    employeeList.add(Employee(789,"Bharati", "Hegde"))


    println(employeeList.capacity())
    employeeList.iterator().forEach {
        println(it.firstName)
    }

}

fun arraylist() {

    var employeeList:MutableList<Employee> = arrayListOf()

    employeeList.add(Employee(123,"Ganesh", "Hegde"))
    employeeList.add(Employee(456,"Rama", "Hegde"))
    employeeList.add(Employee(789,"Bharati", "Hegde"))
    employeeList.add(Employee(100,"Mike", "Wilson"))

//    employeeList.forEach {
//        println(it)
//    }
//
//    println(employeeList.get(1))
//    println(employeeList.isEmpty())

    println(employeeList.set(3, Employee(222, "John", "Adams")))

    employeeList.forEach {
        println(it)
    }

    println(employeeList.size)

    employeeList.add(2, Employee(333,"Rob", "Sharma"))

    employeeList.forEach {
        println(it)
    }


    var toTypedArray = employeeList.toTypedArray()
    toTypedArray.iterator().forEach {
        println(it)
    }

    println(employeeList.contains(Employee(123, "Ganesh", "Hegde")))


    println(employeeList.indexOf(Employee(456,"Rama", "Hegde")))
    println()

    employeeList.remove(Employee(333,"Rob", "Sharma"))
    employeeList.forEach {
        println(it)
    }

}

//abc(true) { it ->
//
//    it.toString()
//}

fun abc(a:Boolean, ab :(a:Boolean) -> Unit) {


    ab(true)
}