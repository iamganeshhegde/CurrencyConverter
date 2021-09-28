package com.example.currencyconverter.miscellaneous.newactivities

class ConvertToLowerCase {
}

fun main() {
    var s = "Hello"

    var newString =""

    for(i in s) {
        if(i.code <= 90) {
           newString += (i.code + 32).toChar()
        } else {
            newString += i
        }
    }

    println(newString)



    var arraylist = mutableListOf<Int>()

    arraylist.add(1)
    arraylist.removeAt(arraylist.size)
    arraylist.add(1)
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