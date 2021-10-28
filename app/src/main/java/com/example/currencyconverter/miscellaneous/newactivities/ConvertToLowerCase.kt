package com.example.currencyconverter.miscellaneous.newactivities

import kotlin.math.absoluteValue

class ConvertToLowerCase {
}

fun main() {
//    var s = "Hello"
//
//    var newString =""
//
//    for(i in s) {
//        if(i.code <= 90) {
//           newString += (i.code + 32).toChar()
//        } else {
//            newString += i
//        }
//    }
//
//    println(newString)
//
//
//
//    var arraylist = mutableListOf<Int>()
//
//    arraylist.add(1)
//    arraylist.removeAt(arraylist.size)
//    arraylist.add(1)




//    println(isIsomorphic("egg", "add"))


    println(isomo("egg", "ade"))

}

fun push(`val`: Int) {

    var arraylist = mutableListOf<Int>()

    var min:Int? = null

    if(min == null) {
        min = `val`
    } else if(`val` < min) {
        min = `val`
    }

    arraylist.add(`val`)

    var newArraylist = arraylist.toMutableList()


    newArraylist.sort()

    newArraylist.sort()
    newArraylist.get(0)

}

fun isIsomorphic(s: String, t: String): Boolean {

    var s = s.toLowerCase()
    var t = t.toLowerCase()
    var diff = s[0].code - t[0].code

    for(i in 1 until s.length) {

        if((s[i].code - t[i].code).absoluteValue != diff) {
            return false
        }

    }
    return true

}

fun isomo(s: String, t: String): Boolean  {
    var map1 = mutableMapOf<Char, Int>()
    var map2 = mutableMapOf<Char, Int>()

    for(i in 0 until s.length){
        if(map1.put(s[i],i) != map2.put(t[i],i)) {
            return false
        }
    }
    return true

}