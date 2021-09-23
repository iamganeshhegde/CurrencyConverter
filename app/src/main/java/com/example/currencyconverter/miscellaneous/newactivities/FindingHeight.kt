package com.example.currencyconverter.miscellaneous.newactivities

class FindingHeight {


}

fun main() {
//    val intArray = intArrayOf(4,2,3,1)
//
//    var newArray = intArray.copyOf()
//
//    newArray.sort()
//
//    newArray[0] != intArray[0]
//
//
//    intArray.iterator().forEach {
//        println(it)
//    }

//    checkheight()

    println(heightChecker(intArrayOf(3,2,4,5)))
}

fun checkheight(){

    var heightsArray = intArrayOf(3,2,4,5)
    var array = IntArray(101)


    var answer =0
    var heightNow = 1

    for (i in 0 until heightsArray.size) {

        array[heightsArray[i]]++

    }


    for (height in heightsArray) {

        while (array[height] == 0) {
            heightNow++
        }

        if(heightNow!= height) {
            answer++
        }
        array[height]--

    }

    println(answer)


}

fun heightChecker(heights: IntArray): Int {
    val map = IntArray(101) // heights go from 1 to 100
    for (h in heights) ++map[h]
    var res = 0
    var h_ptr = 1
    for (h in heights) {
        while (map[h_ptr] == 0) ++h_ptr
        if (h_ptr != h) {
            ++res
        }
        --map[h_ptr]
    }
    return res
}