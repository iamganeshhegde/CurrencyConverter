package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*

class RemoveDuplicateString {
}

fun main() {

    var s = "abbaca"


    var stack = Stack<Char>()
    stack.push(s[0])

    for(i in 1 until s.length){
        if(stack.empty()) {
            stack.push(s[i])
        } else {
            if(s[i] == stack.peek()) {
                stack.pop()
            } else {
                stack.push(s[i])
            }
        }

    }

    var string = StringBuilder()

    while (stack.empty().not()) {
        string.append(stack.pop())
    }
    string.toString().reversed()

    println(string)


}

