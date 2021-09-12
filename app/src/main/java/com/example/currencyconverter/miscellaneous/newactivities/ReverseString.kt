package com.example.currencyconverter.miscellaneous.newactivities

class ReverseString {
}

fun main() {

    reverseString(charArrayOf('a','b','c'))

}

fun reverseString(s: CharArray): Unit {

    var s=s

    var a = CharArray(s.size)

    for(i in 0 until s.size)  {

        a[i] = s[s.size-1-i]

    }


    a.iterator().forEach{
        println(it)
    }



}
