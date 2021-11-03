package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Build
import androidx.annotation.RequiresApi

class InterSectionArray {



}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    var array = intArrayOf(4,9,5)
    var second = intArrayOf(9,4,9,8,4)

    var answer = mutableListOf<Int>()


    var hashmap = mutableMapOf<Int,Int>()

    for(i in 0 until array.size) {
        hashmap.put(array[i],hashmap.getOrDefault(array[i],0)+1)
    }

    hashmap.entries.forEach {
        println("${it.key}, ${it.value}")
    }

    for (i in 0 until second.size) {

        if(hashmap.containsKey(second[i]) && hashmap.getValue(second[i]) > 0) {

            answer.add(second[i])
            hashmap.put(second[i], hashmap.get(second[i])!! -1)

        }

    }

    var answerArray = answer.toIntArray()


//    answerArray.iterator().forEach {
//        println(it)
//    }


    intersection()
}


fun intersection() {

//    var array = intArrayOf(4,5,9)
    var array = intArrayOf(1,2,3,4)

//    var second = intArrayOf(4,4,8,9,9)
    var second = intArrayOf(1,2,2,2)

    var answer = mutableListOf<Int>()

    var i=0
    var j=0


    while(i < array.size && j<second.size) {
        if(array[i] == second[j]) {
            answer.add(array[i])
            i++
            j++

        } else if(array[i] < second[j]) {
            i++
        }else if(array[i] > second[j]) {
            j++
        }
    }

    answer.iterator().forEach {
        println(it)
    }


}