package com.example.currencyconverter.miscellaneous.newactivities

import android.R.attr


class MergeSortActivityR {
}


fun main() {

    var array = intArrayOf(70,10,40,20)

//    mergeSortt(array, 0, array.size-1)


//    mergeSorttt(array,0,3)


    mergeSorting(array,0,3)
    array.iterator().forEach {
        println("sorted $it")
    }
}

fun mergeSortt(array: IntArray, start:Int, end:Int) {

    if(start < end) {

        var middle = (start+end) /2

        mergeSortt(array, start, middle)
        mergeSortt(array, middle+1, end)
        mergee(array,start,middle,end)
    }

    array.iterator().forEach {
        println("after sort $it")
    }
}

fun mergee(array: IntArray, start: Int, middle: Int, end: Int) {

    var i =middle-start+1;
    var j=end - middle;
    var k=0

    var x=0
    var y=0
    var z =start
    var newArray = IntArray(end-start+1)
    while (x < middle && y < end) {
        if(array[x] <= array[y]) {
            newArray[k++] = array[x++]
//            var temp = array[i]
//            array[i] = array[j]
//            array[j] = temp
        } else {
            newArray[k++] = array[y++]
        }
    }


    while (x < i) {
        newArray[k++] = array[i++]
    }

    while (y < j) {
        newArray[k++] = array[j++]
    }

    for (z in start .. end) {
        array[z] = newArray[i-start]

    }


    newArray.iterator().forEach { println(it) }
    println()

    array.iterator().forEach {
        println("array  jsut - $it")
    }
    println()
}


fun mergeSorttt(Arr: IntArray, start: Int, end: Int) {
    if (start < end) {
        val mid = (start + end) / 2
        mergeSortt(Arr, start, mid)
        mergeSortt(Arr, mid + 1, end)
        mergeee(Arr!!, start, mid, end)
    }

    Arr.iterator().forEach {
        println("values $it")
    }
}



fun mergeee(Arr:IntArray,  start:Int, mid:Int, end:Int) {
    // create a temp array
    // create a temp array
    val temp = IntArray(attr.end - start + 1)

    // crawlers for both intervals and for temp

    // crawlers for both intervals and for temp
    var i = start
    var j = mid + 1
    var k = 0


    while(i <= mid && j <= end) {
        if(Arr[i] <= Arr[j]) {
            temp[k] = Arr[i];
            k += 1; i += 1;
        }
        else {
            temp[k] = Arr[j];
            k += 1; j += 1;
        }
    }

    // add elements left in the first interval
    while(i <= mid) {
        temp[k] = Arr[i];
        k += 1; i += 1;
    }

    // add elements left in the second interval
    while(j <= end) {
        temp[k] = Arr[j];
        k += 1; j += 1;
    }

    for(i in start .. end) {
        Arr[i] = temp[i - start]
    }

}


// Merge two subarrays L and M into arr
fun merges(arr: IntArray, p: Int, q: Int, r: Int) {

    // Create L ← A[p..q] and M ← A[q+1..r]
    val n1 = q - p + 1
    val n2 = r - q
    val L = IntArray(n1)
    val M = IntArray(n2)
    for (i in 0 until n1) L[i] = arr[p + i]
    for (j in 0 until n2) M[j] = arr[q + 1 + j]

    // Maintain current index of sub-arrays and main array
    var i: Int
    var j: Int
    var k: Int
    i = 0
    j = 0
    k = p

    // Until we reach either end of either L or M, pick larger among
    // elements L and M and place them in the correct position at A[p..r]
    while (i < n1 && j < n2) {
        if (L[i] <= M[j]) {
            arr[k] = L[i]
            i++
        } else {
            arr[k] = M[j]
            j++
        }
        k++
    }

    // When we run out of elements in either L or M,
    // pick up the remaining elements and put in A[p..r]
    while (i < n1) {
        arr[k] = L[i]
        i++
        k++
    }
    while (j < n2) {
        arr[k] = M[j]
        j++
        k++
    }
}


fun mergeSorting(arr: IntArray?, l: Int, r: Int) {
    if (l < r) {

        // m is the point where the array is divided into two subarrays
        val m = (l + r) / 2
        mergeSorting(arr, l, m)
        mergeSorting(arr, m + 1, r)

        // Merge the sorted subarrays
        merges(arr!!, l, m, r)
    }
}

