package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Build
import androidx.annotation.RequiresApi


class UnCommonFromSentence {
}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
//    uncommonFromSentences("s z z z s" ,"s z ejt").iterator().forEachRemaining {
//        println(it)
//    }

    smalll()
}

@RequiresApi(Build.VERSION_CODES.N)
fun uncommonFromSentences(s1: String, s2: String): Array<String> {

    var answer = mutableListOf<String>()


    var array1 = s1.split(" ")
    var array2 = s2.split(" ")

    var start1 = 0
    var start2 = 0

    var hash1: MutableMap<String, Int> = mutableMapOf<String, Int>()

    var hash2 = mutableMapOf<String, Int>()

    var hash3 = mutableMapOf<String, Int>()


    for (i in 0 until array1.size) {

        if (hash1[array1[i]] != null) {
            hash1[array1[i]] = hash1[array1[i]]!! + 1
        } else {
            hash1[array1[i]] = 1

        }

    }

    for (i in 0 until array2.size) {

        if (hash2[array2[i]] != null && hash2.containsKey(array2[i])) {
            hash2[array2[i]] = hash2[array2[i]]!! + 1
        } else {
            hash2[array2[i]] = 1

        }

    }


    hash1.entries.iterator().forEachRemaining {
//        if (it.value == 1) {
            hash3[it.key] = it.value
//        }
    }

    hash2.entries.iterator().forEachRemaining {
//        if (it.value == 1) {
            if (hash3.containsKey(it.key)) {
                hash3[it.key] = hash3[it.key]!! + 1
            } else {
                hash3[it.key] = 1
            }
        }
//    }


    hash3.entries.iterator().forEachRemaining {
        if (it.value == 1) {
            answer.add(it.key)
        }
    }

    return answer.toTypedArray()


}

@RequiresApi(Build.VERSION_CODES.N)
fun uncommonFromSentencesa(A: String, B: String): Array<String>? {
    val count: MutableMap<String, Int> = HashMap()
    for (w in "$A $B".split(" ").toTypedArray()) count[w] = count.getOrDefault(w, 0) + 1
    val res = ArrayList<String>()
    for (w in count.keys) if (count[w] == 1) res.add(w)
    return res.toTypedArray()
}


fun smallestRangeI(A: IntArray, K: Int): Int {
    var mx = A[0]
    var mn = A[0]
    for (a in A) {
        mx = Math.max(mx, a)
        mn = Math.min(mn, a)
    }
    return Math.max(0, mx - mn - 2 * K)
}

fun smalll() {
    var array = intArrayOf(1,3,6)
    var k = 3

    var max = array.maxOrNull()
    var min = array.minOrNull()


    max = max!! - k
    min = min!! + k

    println("max $max")
    println("min $min")

    println(max-min)


}






