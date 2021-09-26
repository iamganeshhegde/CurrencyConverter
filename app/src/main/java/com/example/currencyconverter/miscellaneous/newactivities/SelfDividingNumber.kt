package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*


class SelfDividingNumber {
}

fun main() {

}

fun selfDividingNumbers(left: Int, right: Int): List<Int>? {
    val res: MutableList<Int> = ArrayList()
    var i = left
    var n = 0
    while (i <= right) {
        n = i
        while (n > 0) {
            if (n % 10 == 0 || i % (n % 10) != 0) break
            n /= 10
        }
        if (n == 0) res.add(i)
        i++
    }
    return res
}

fun selfDividingNumberss(left: Int, right: Int): List<Int>? {
    val list: MutableList<Int> = ArrayList()
    for (i in left..right) {
        var j = i
        while (j > 0) {
            if (j % 10 == 0 || i % (j % 10) != 0) break
            j /= 10
        }
        if (j == 0) list.add(i)
    }
    return list
}