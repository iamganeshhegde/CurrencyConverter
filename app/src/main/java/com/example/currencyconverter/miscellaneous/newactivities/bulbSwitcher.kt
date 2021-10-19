package com.example.currencyconverter.miscellaneous.newactivities

class bulbSwitcher {
}

fun main() {
    switch("10111")
}

fun switch(target:String): Int {
    var prev = '0'
    var res = 0

    for (c in target.toCharArray()) {
        if(c != prev) {
            prev = c
            res++
        }
    }

    return res
}