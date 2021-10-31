package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*

class ShareBuy {
}
fun main() {


    var a = IntArray(7){i -> i+1}
    var b = IntArray(4) {
        i -> i
    }
//
//    a.iterator().forEach{ println(it) }
//    b.iterator().forEach{ println(it) }
//
//
//    var answer = a+b
//
//    answer.iterator().forEach {
//        println(it)
//    }


    rotate(a,3)

}

fun rotate(nums: IntArray, k: Int): Unit {

    var nums = nums
    var first = IntArray(k)
    var answer = IntArray(nums.size)
    var second = IntArray(nums.size-k)

    for(i in 0 until first.size) {

        first[i] = nums[nums.size-k+i]

    }

    for(i in 0 until second.size) {

        second[i] = nums[i]

    }

    answer = first+second

    nums = answer

    nums.iterator().forEach { println(it) }
    // return answer

}

fun maxProfit(prices: IntArray): Int {

    var hashmap = mutableMapOf<Int, Int>()

    for(i in 0 until prices.size) {
        hashmap.put(i,prices[i])
    }


    var find = hashmap.keys.find { it == 3 }

    var key = hashmap.entries.find { it.key == 3 }?.key


    var stack = Stack<Int>()

    var sum = 0

    for (i in 0 until prices.size) {

        if(stack.isEmpty()) {
            stack.push(prices[i])
        } else {
            if( prices[i] < stack.peek()) {
                stack.pop()
                stack.push(prices[i])
            } else if( prices[i] >= stack.peek() ) {
                var answer = prices[i]-stack.peek()
                sum += answer
                stack.clear()
            }
        }

    }



    var low:Int? = null
    var high:Int? = null

    low = prices[0]
    high = prices[0]

    for(i in 1 until prices.size) {

//        if(prices[i] > high && ) {
//
//        }


    }


    return sum

}


fun rotatee(nums: IntArray?, k: Int) {
    var k = k
    if (nums == null || nums.size < 2) {
        return
    }
    k = k % nums.size
    reverse(nums, 0, nums.size - k - 1)
    reverse(nums, nums.size - k, nums.size - 1)
    reverse(nums, 0, nums.size - 1)
}

private fun reverse(nums: IntArray, i: Int, j: Int) {
    var i = i
    var j = j
    var tmp = 0
    while (i < j) {
        tmp = nums[i]
        nums[i] = nums[j]
        nums[j] = tmp
        i++
        j--
    }
}