package com.example.currencyconverter.miscellaneous.newactivities

class Extension {



}

fun main() {
    var a = 20;

    println(a.add(50))
    println(a.add(50, 60))
}

fun Int.add(a:Int, b:Int): Int {
   return a+b
}

fun Int.add(a:Int): Int {
    return this+a
}