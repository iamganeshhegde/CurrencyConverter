package com.example.currencyconverter.miscellaneous.newactivities

class RotateArrayActivity {
}

fun main() {


//    fullRotate(intArrayOf(1,2,3,4,5),3)
    var array = intArrayOf(1, 2, 3, 4, 5)

    rotateArray(array, 0, 1)
    rotateArray(array, 2, 4)
    rotateArray(array, 0, 4)


}

fun fullRotate(array: IntArray, times: Int) {
    for (i in 0 until times) {
        rotate(array).iterator().forEach {
            println(it)
        }

        println()

    }
}

fun rotate(array: IntArray): IntArray {

    var temp = array[0]
    for( i in 0 until array.size-1) {
        array[i] = array[i+1]
    }

    array[array.size-1] = temp


//    var start = 0
//    var end = array.size - 1
//
//    while (start < end) {
//        var temp = array[start]
//        array[start] = array[end]
//        array[end] = temp
//        start++
//        end--
//    }

    return array

}

fun rotateArray(array: IntArray, start: Int, upTo: Int) {

//    var temp = array[start]
//
//    for (i in start until upTo) {
//        array[i] = array[i + 1]
//    }
//    array[upTo] = temp
//
//    println()



    var start = start
    var upTo = upTo

    while (start < upTo) {
        var temp = array[start]
        array[start] = array[upTo]
        array[upTo] = temp
        start++
        upTo--
    }

    array.iterator().forEach {
        println("round -  $it")
    }
    println()

}
