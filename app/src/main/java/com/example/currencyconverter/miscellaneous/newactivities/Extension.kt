package com.example.currencyconverter.miscellaneous.newactivities

import android.content.Context
import android.widget.Toast

class Extension {



}

fun main() {
    var a = 20;

    println(a.add(50))
    println(a.add(50, 60))

//    Context.show()
}

fun Int.add(a:Int, b:Int): Int {
   return a+b
}

fun Int.add(a:Int): Int {
    return this+a
}

fun Context.show() {
    Toast.makeText(this,"sss",Toast.LENGTH_SHORT).show()
}