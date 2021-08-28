package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Build
import androidx.annotation.RequiresApi


class SixthActivity {
}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {


//    testMissingNumber()

//    jj().forEach { println(it) }

    hashmap().forEach { println(it) }

}

fun testMissingNumber() {
    var i =1

    var array = IntArray(5) {
        i++
    }

   array.iterator().forEach { println(it) }
}

fun jj (): IntArray {

    var nums = intArrayOf(4,3,3,1)
    val array = IntArray(nums.size + 1)
    for (i in 0 until nums.size) {
        array[nums.get(i)]++
    }
    var repeatedNumber = 0
    var missingNumber = 0
    var index = 0
    for (count in array) {
        if (count == 0) missingNumber = index
        if (count == 2) repeatedNumber = index
        index++
    }
    return intArrayOf(repeatedNumber, missingNumber)
}


@RequiresApi(Build.VERSION_CODES.N)
fun hashmap (): IntArray {
    var nums = intArrayOf(4,3,3,1)

    val map: HashMap<Int?, Int?> = HashMap<Int?, Int?>()
    var dup = -1
    var missing = 1
    for (n in nums) {
        map.put(n, map.getOrDefault(n, 0) as Int + 1);
    }
    for (i in 1..nums.size) {
        if (map.containsKey(i)) {
            if (map[i] == 2) dup = i
        } else missing = i
    }


    return intArrayOf(dup, missing)
}
