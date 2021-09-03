package com.example.currencyconverter.miscellaneous.newactivities

class ArrayTestActivity {
}


fun main() {
    println(sumOfUnique(intArrayOf(1,2,3,2)))
}

fun sumOfUnique(nums: IntArray): Int {

    var sum =0

    var array = Array<Int>(100) {0}



    for(i in 0 until nums.size) {

        array[nums[i]] += 1

    }

    array.iterator().forEach {
        println(it)
    }

    for(i in 0 until array.size) {

        if(array[i] == 1) {
            sum = sum+i
        }

    }

    return sum



}