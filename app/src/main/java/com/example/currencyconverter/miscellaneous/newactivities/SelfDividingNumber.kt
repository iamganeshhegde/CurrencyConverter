package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*


class SelfDividingNumber {
}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {

    selfDividingNumberss(12, 12)?.iterator()?.forEachRemaining {
        println(it)
    }

    println()
    var int = 1
    println(int/10)

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
            j = j.div(10)
        }
        if (j == 0) list.add(i)
    }
    return list
}

fun aaa() {
    var intArray = IntArray(10)
    var arraylist = mutableListOf<Int>()
    intArray[0] = Math.abs(Math.min(arraylist[0] - 0, arraylist[1]-0))
}