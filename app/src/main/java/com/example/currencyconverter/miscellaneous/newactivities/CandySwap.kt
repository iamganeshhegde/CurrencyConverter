package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.stream.IntStream


class CandySwap {
}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {

    var array = intArrayOf(1,2)
    var array2 = intArrayOf(3,4)

    array.sum()


    fairCandySwap(array, array2)?.iterator()?.forEachRemaining {
        println(it)
    }

}

@RequiresApi(Build.VERSION_CODES.N)
fun fairCandySwap(A: IntArray, B: IntArray): IntArray? {
    val dif = (A.sum() - B.sum()) / 2
    val S = HashSet<Int>()
    for (a in A) S.add(a)
    for (b in B) if (S.contains(b + dif)) return intArrayOf(b + dif, b)
    return IntArray(0)
}