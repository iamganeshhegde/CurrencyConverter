package com.example.currencyconverter.miscellaneous.newactivities

class OddArray {
}

fun main() {

//    println(sumOddLengthSubarrays(intArrayOf(1,2,3,4,5)))


//    var arrylist = mutableListOf<Int>()

//    arrylist.add(1,0)
//    println(arrylist)
//
//    var toIntArray = arrylist.toIntArray()


//    println(reverse("abcd"))



//    println(reverseNumber(5))


    println(reverseWords("abcd"))

}

fun sumOddLengthSubarrays(arr: IntArray): Int {
    var result = 0
    val n = arr.size
    for (i in 0 until n) {
        val end = i + 1
        val start = n - i
        val total = start * end
        var odd = total / 2
        if (total % 2 == 1) {
            odd++
        }
        result += odd * arr[i]
    }
    return result
}

fun reverse(string:String):String {

    if(string.isNotEmpty()) {

        reverse(string.dropLast(1))

    }

    println(string)
    return string

}

fun reverseNumber(number: Int):Int {

    if(number > 0) {
        reverseNumber(number-1)
    }


//    println(number)
    return number

}


fun reverseWords(s: String): String {


    var array = s.split(" ")


    var answer = ""

    for(i in s.length-2 downTo 0) {
        answer = answer+answer[i]
    }

    return answer

}