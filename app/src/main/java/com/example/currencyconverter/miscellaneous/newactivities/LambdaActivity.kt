package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*

class LambdaActivity {
}

fun main() {

    //lambda
    val upperCaseVal: (string: String, number:Int) -> String = { str: String, number:Int ->
        str.uppercase(Locale.getDefault())+number
    }

    println(upperCaseVal.invoke("aaa",2))


    fun uppercaseNew(string: String): String {
        return string.uppercase(Locale.getDefault())
    }




    //higher order function
    fun calculate(x:Int, y:Int, operation:(Int,Int) -> Int): Int {

        return operation(x,y)
    }


    fun summ(x:Int, y:Int) = x+y

    val sumVal = { x:Int, y:Int ->
        x+y
    }
    println(calculate(6,7,sumVal))

    println(calculate(1,2, ::summ))

    println(calculate(3,4) { x, y ->
        x * y
    })

}