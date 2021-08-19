package com.example.currencyconverter.miscellaneous.newactivities

class FourthActivity {

    private var a = ThirdActivity()
}

fun main() {
//    val intArray = intArrayOf(20, 35, -15, 7, 55, 1, -22)
//    mergeSort(intArray, 0, intArray.size)
//    for (i in intArray.indices) {
//        println(intArray[i])
//    }

//    insertionSort()


//    var array = intArrayOf(1,6,2,5)
//    newMergeSort(array, 0, array.size-1)


//    justmerge()

//    radixSort()


    var a:String ="a"
    var b = "b"
    var answer = b[0].code - a[0].code

    println(answer)

}




//Radix sort
fun radixSort() {
    val stringsArray = arrayOf("bcdef", "dbaqc", "abcde", "omadd", "bbbbb")

    // do radix sort
    for (i in stringsArray.indices) {
        println(stringsArray[i])
    }
}


fun radix(array: IntArray, radix:Int, width:Int) {

    for(i in 0 until width) {

    }
}

fun newMergeSort(array: IntArray, start: Int, end: Int) {

    if(start <= end) {
        return
    }

    var mid = (start+end)/2

    newMergeSort(array, start, mid)
    newMergeSort(array, mid+1, end)
    mergeIt(array, start, mid, end)




}

//merge 2 sorted arrays
fun mergeIt(array: IntArray, start: Int, mid: Int, end: Int) {

//    for(i in start until end) {
//        if()
//    }

}



fun justmerge() {

    var first = intArrayOf(1,2,3)
    var second = intArrayOf(4,5,6)
    var result = IntArray(first.size+second.size)
    var i=0
    var j=0
    var k=0

    while (i < first.size && j <second.size) {

        if(first[i] < second[j]) {
            result[k++] = first[i++]
        } else{
            result[k++] = second[j++]
        }
    }


    while(i < first.size) {
        result[k++] = first[i++]
    }
    while(j<second.size) {
        result[k++] = second[j++]
    }


    result.asIterable().forEach { println(it) }

//    fun truncateSentence(s: String, k: Int): String {

//        var array:Array<Char> = s.split("")
//
//        array =
//        return array

//    }
}





fun mergeSort(input: IntArray, start: Int, end: Int) {
    if (end - start < 2) {
        return
    }
    val mid = (start + end) / 2
    mergeSort(input, start, mid)
    mergeSort(input, mid, end)
    merge(input, start, mid, end)
}

fun merge(input: IntArray, start: Int, mid: Int, end: Int) {
    if (input[mid - 1] > input[mid]) {
        return
    }
    var i = start
    var j = mid
    var tempIndex = 0
    val temp = IntArray(end - start)
    while (i < mid && j < end) {
        temp[tempIndex++] = if (input[i] > input[j]) input[i++] else input[j++]
    }
    System.arraycopy(input, i, input, start + tempIndex, mid - i)
    System.arraycopy(temp, 0, input, start, tempIndex)
}



//Insertion sort
fun insertionSort() {
    val intArray = intArrayOf(20, 35, -15, 7, 55, 1, -22)
    for (firstUnsortedIndex in 1 until intArray.size) {
        val newElement = intArray[firstUnsortedIndex]
        var i: Int = firstUnsortedIndex
        while (i > 0 && intArray[i - 1] > newElement) {
            intArray[i] = intArray[i - 1]
            i--
        }
        intArray[i] = newElement
    }
    for (i in intArray.indices) {
        println(intArray[i])
    }
}