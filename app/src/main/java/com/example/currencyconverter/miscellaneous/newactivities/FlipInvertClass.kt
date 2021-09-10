package com.example.currencyconverter.miscellaneous.newactivities

class FlipInvertClass {
}

fun main() {

//    var array = Array<IntArray>(10){}


//    var arr = Array<IntArray>(10) { intArrayOf(it)}


    flipAndInvertImage(arrayOf(intArrayOf(1,1,0), intArrayOf(1,0,1), intArrayOf(0,0,0))).iterator().forEach {
//    flipAndInvertImage(arrayOf(intArrayOf(1,0,0), intArrayOf(1,0,1), intArrayOf(0,0,0))).iterator().forEach {
        it.iterator().forEach { print(it) }
        println()
    }



}


//[[1,0,0],[0,1,0],[1,1,1]] - answer
fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {


//    var array = arrayOfNulls<IntArray>(image.size)
    var array = image

    for(i in 0 until image.size) {

        for(j in image[i].size-1 downTo 0) {

            //flip
            array[i]!![image[i].size-1-j] = image[i][j]

            print(array[i][image[i].size-1-j])
            print(" - > array[$i][${image[i].size-1-j}]      ")


            print(image[i][j])
            print(" - > image[$i][${j}]      ")
        }
        println()

    }
    println("flipped:")

    array.iterator().forEach {
        it.iterator().forEach {
            print(it)
        }
        println()

    }

    println()


    for(i in 0 until array.size) {

        for(j in 0 until array[i]!!.size-1) {

            //invert
            if(array[i]!![j] == 0) {
                array[i]!![j] = 1
            } else {
                array[i]!![j] = 0
            }
        }
    }

    return array!!
}


fun flipAndInvertImagee(A: Array<IntArray>): Array<IntArray> {
    for (i in A.indices) {
        var lo = 0
        var hi: Int = A[0].size - 1
        while (lo <= hi) {
            if (A[i][lo] == A[i][hi]) {
                A[i][lo] = 1 - A[i][lo]
                A[i][hi] = A[i][lo]
            }
            lo++
            hi--
        }
    }
    return A
}