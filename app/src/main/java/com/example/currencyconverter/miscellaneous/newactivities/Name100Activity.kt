package com.example.currencyconverter.miscellaneous.newactivities

class Name100Activity {

}

fun main() {
    var name = "Ganesh \n"

    var array = arrayOf(name)


//    print(String.format("%010d",0).replace("0","Ganesh\n"));


    println(String.format("%010d", 777).replace('0', '*'))




}
fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    var ans = 0
    var max = 0
    for (i in timeSeries) {
        if (i < max) {
            ans += i + duration - max
            max = i + duration
        } else {
            ans += duration
            max = i + duration
        }
    }
    return ans
}