package com.example.currencyconverter.miscellaneous.newactivities

class BinarySearchActivity {
}

fun main() {

    val array = intArrayOf(-15, -1, 3, 5, 8, 55, 88)

    binarySearch(array, 0, array.size)


}

fun binarySearch(array: IntArray, start: Int, end: Int) {

    var start = start
    var end = end

    var element = 55

    println("Starting")

    while (start< end) {
        var mid = (end+start)/2
        if(array[mid] == element) {
            println("Found at $mid")
            return
        }else if (element > array[mid]) {
            start = mid+1
        } else if(element < array[mid]){
            end = mid
        }
    }


    println("end")

}
