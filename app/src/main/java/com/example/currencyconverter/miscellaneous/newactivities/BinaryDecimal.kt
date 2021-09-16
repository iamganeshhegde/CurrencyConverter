package com.example.currencyconverter.miscellaneous.newactivities

import java.math.BigInteger

class BinaryDecimal {
}

fun main() {
//    val num = Integer.toBinaryString(12)
//    println(num)
//
//    println(BigInteger("100",2))
//
//
//    var a = 4
//
//    var reduce = (1..a).reduce { a, b -> a * b }
//
//    println(reduce)
//
//
////    (1.. a).fold(1)
//
//    var list = listOfNotNull<Int>()
//
//    list = emptyList()


    println(addDigits(999))


}


fun addDigits(num: Int): Int {

    while (num<10) {
        return num
    }

    var num = num
    var list = mutableListOf<Int>()
    var sum = 0



    while (num > 10) {
        var temp = num % 10
        num = num / 10
        list.add(temp)
    }

    list.add(num)
    println()


    list.iterator().forEach { println(it) }




    for (i in 0 until list.size) {
        sum = sum + list[i]
    }

    var addDigits = addDigits(sum)

    return addDigits

}