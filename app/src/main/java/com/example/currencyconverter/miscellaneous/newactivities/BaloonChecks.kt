package com.example.currencyconverter.miscellaneous.newactivities

object Code {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello from Java!")
        val red = Balloon("Red")
        val blue = Balloon("Blue")
        swap(red, blue)
        println("red color: " + red.color)
        println("blue color: " + blue.color)
        foo(blue)
        println("blue color: " + blue.color)
    }

    fun foo(balloon: Balloon) {
        var balloon = balloon
        balloon.color = "Red"
        balloon = Balloon("Green")
        balloon.color = "Blue"
    }

    fun swap(o1: Any?, o2: Any?) {
        var o1 = o1
        var o2 = o2
        val temp = o1
        o1 = o2
        o2 = temp
    }
}

class Balloon(var color: String)