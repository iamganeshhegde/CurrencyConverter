package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Build
import androidx.annotation.RequiresApi

class LowestDistanceForACharacter {


}


@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    shortestToChar("loveleetcode", 'e')?.iterator()?.forEachRemaining {
        println(it)
    }
}

fun shortestToChar(S: String, C: Char): IntArray? {
    val n = S.length
    var pos = -n
    val res = IntArray(n)
    for (i in 0 until n) {
        if (S[i] == C) pos = i
        res[i] = i - pos
    }
    for (i in pos - 1 downTo 0) {
        if (S[i] == C) pos = i
        res[i] = Math.min(res[i], pos - i)
    }
    return res
}

fun peakIndexInMountainArray(arr: IntArray): Int {

    var pos = 0

    for(i in 1 until arr.size) {

        if(arr[i] > arr[pos] ) {
            pos = i
        }

    }

    return pos

}