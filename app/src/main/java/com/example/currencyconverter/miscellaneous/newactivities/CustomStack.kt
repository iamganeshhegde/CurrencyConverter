package com.example.currencyconverter.miscellaneous.newactivities

internal class CustomStack(maxSize: Int) {
    var stack: IntArray = IntArray(maxSize)
    var size: Int = maxSize
    var index: Int = 0
    fun push(x: Int) {
        if (index < size) {
            stack[index++] = x
        }
    }

    fun pop(): Int {
        return if (index == 0) -1 else stack[--index]
    }

    fun increment(k: Int, `val`: Int) {
        if (stack.size == 0) return
        var i = 0
        while (i < k && i < stack.size) {
            stack[i] = stack[i] + `val`
            i++
        }
    }

}