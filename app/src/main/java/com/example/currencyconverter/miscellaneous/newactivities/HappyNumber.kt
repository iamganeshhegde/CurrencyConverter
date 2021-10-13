package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*


class HappyNumber {
}

fun main() {
    println(isHappy(19))
}

fun isHappy(n: Int): Boolean {
    var n = n
    val set = mutableSetOf<Int>()
    set.add(n)
    while (n != 1) {
        var result = 0
        while (n != 0) {
            result += Math.pow((n % 10).toDouble(), 2.0).toInt()
            n /= 10
        }
        if (set.contains(result)) {
            return false
        }
        set.add(result)
        n = result
    }
    return true
}

