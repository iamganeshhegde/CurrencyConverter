package com.example.currencyconverter.miscellaneous.newactivities

class FInalPriceAfterDiscountClass {
}

fun main() {
   finalPrices(intArrayOf(3,2,1)).iterator().forEach { println(it) }
}

fun finalPrices(prices: IntArray): Array<Int?> {

    var lowest = 0

    var aaa = IntArray(10)

    var array =  arrayOfNulls<Int>(prices.size)
    var i = 0
    var j =i+1
    while(i < prices.size) {

        while(j < prices.size) {

            if(prices[j] < prices[i]) {
                array[i] = prices[i] - prices[j]
                break
            } else {
                array[i] = prices[i]
            }

            j++
        }
        i++

    }

    return array

}