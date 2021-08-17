package com.example.currencyconverter

import android.os.Bundle
import android.text.SpannableString.valueOf
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


    }

}


fun main() {

//    smallerNumbersThanCurrent(intArrayOf(8,2,1,1,3))

    mapping()

}

fun mapping() {

    var input = "codeleet"
    var inputArray = intArrayOf(4,5,6,7,0,2,1,3)
    var arr = arrayOf("a","b","c")

    var hashmap = mutableMapOf<Int, String>()
    var string = ""


    for(i in 0 until inputArray.size) {
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
        }
        else {
            res[i] = count[nums[i] - 1]
            print("res[i] - $i  - ${res[i]}, ")
        }
    }
    return res
}