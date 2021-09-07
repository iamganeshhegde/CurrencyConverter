package com.example.currencyconverter.miscellaneous.newactivities

class OddArray {
}

fun main() {

    println(sumOddLengthSubarrays(intArrayOf(1,2,3,4,5)))
}

fun sumOddLengthSubarrays(arr: IntArray): Int {
    var result = 0
    val n = arr.size
    for (i in 0 until n) {
        val end = i + 1
        val start = n - i
        val total = start * end
        var odd = total / 2
        if (total % 2 == 1) {
            odd++
        }
        result += odd * arr[i]
    }
    return result
}