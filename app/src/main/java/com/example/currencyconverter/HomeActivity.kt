package com.example.currencyconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


    }

}


fun main() {

//    smallerNumbersThanCurrent(intArrayOf(8,2,1,1,3))

//    mapping()

//    println(mySqrt(2147483647).toString())

//    squareroot(8)

    println(numberMiss(intArrayOf(3,4,2,0,1,6)))

}


//find missing number from array
fun missingNumber(nums: IntArray): Int {
    var sum = 0
    var i = 0
    while (i < nums.size) {
        sum = sum + i - nums[i]
        i++
    }
    return sum + i
}


//println(numberMiss(intArrayOf(3,4,2,0,1,6)))
fun numberMiss(nums:IntArray): Int {
    var res: Int = nums.size
    println("res $res")

    for (i in 0 until nums.size) {
        res = res xor i xor nums.get(i) // a^b^b = a


        println("res and i -  $res,  $i")
    }
    return res
}

fun mapping() {

    var input = "codeleet"
    var inputArray = intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)
    var arr = arrayOf("a", "b", "c")

    var hashmap = mutableMapOf<Int, String>()
    var string = ""


    for (i in 0 until inputArray.size) {
        hashmap.put(inputArray[i], input.get(i).toString())
    }


    val sortedMap: MutableMap<Int, String> = TreeMap(hashmap)

    hashmap.entries.sortedBy { it.key }.forEach {
        string += it.value
    }

//    println(string)

    println(inputArray.toString())
//    valueOf(arr)

}

fun restoreString(s: String, indices: IntArray): String? {
    val arr = CharArray(s.length)
    for (i in indices.indices) arr[indices[i]] = s[i]
    return String(arr)
}

//find square root
fun mySqrt(x: Int): Int {

    var answer = 0

    if (x == 1 || x == 2 || x == 3) {
        return 1
    }
    var abc: Long = 0

    for (abc in 0..(x / 2) + 1) {
        if (abc * abc == x) {
            answer = abc
            return answer
        } else if (abc * abc > x) {
            answer = abc - 1
            return answer
        }
    }

    return answer

}


fun squareroot(x:Int) {

    var first = 1
    var last = x


    while (first < last) {
        var mid = (first + (last-first)) /2

        if(mid <= x/mid && (mid+1) > x/(mid+1) ) {
            println("mid $mid");
            return
        } else if( mid > x/mid ){
            last = mid
        } else {
            first = mid+1
        }
    }

    println("first $first");



}


// find smaller number by counting sort technique
// for a O(n) time complexity
fun smallerNumbersThanCurrent(nums: IntArray): IntArray? {
    val count = IntArray(11)
    val res = IntArray(nums.size)
    for (i in nums.indices) {

        count[nums[i]]++

        println("count[nums[i]] - ${count[nums[i]]}   - $i")

    }
    for (i in 1..10) {
        print("count[i] - $i - ${count[i]}, ")
        count[i] += count[i - 1]

        print("after    count[i] - $i - ${count[i]}, ")

    }
    println()
    for (i in nums.indices) {
        if (nums[i] == 0) {
            res[i] = 0
        } else {
            res[i] = count[nums[i] - 1]
            print("res[i] - $i  - ${res[i]}, ")
        }
    }
    return res
}