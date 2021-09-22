package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class NextGreatElement {
}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {

//    var nextGreaterElement = nextGreaterElement(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2))
//    var nextGreaterElement = nextGreaterElement(intArrayOf(2,4),intArrayOf(1,2,3,4))
//    var nextGreaterElement = nextGreaterElementt(intArrayOf(2,4),intArrayOf(1,2,3,4))
//
//    nextGreaterElement?.iterator()?.forEach {
//        println(it)
//    }
//
//
//    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
//    var testDate = dateFormat.parse("12/09/2021")
//
//
//    var testCalendar = Calendar.getInstance(TimeZone.getTimeZone("PST"))
//    testCalendar.time = testDate
//
//    val msDiff: Long = Calendar.getInstance().getTimeInMillis() - testCalendar.getTimeInMillis()
//    val daysDiff: Long = TimeUnit.MILLISECONDS.toDays(msDiff)
//
//
//    println(daysDiff)

//    var majorityElement = majorityElement(intArrayOf(3, 2, 3))
//
//    println(majorityElement)


    major()


}

fun test() {
    var answerArray = IntArray(5){
        -1
    }
}


fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {

    var answerArray = IntArray(nums1.size){
        -1
    }

    var i =0

    var nextGreaterNumber = -1


    while(i < nums1.size) {

        var position = -1
        var number = nums1[i]
        var j=0


        while(j < nums2.size) {

            if(position != -1) {
                if(nums2[j] > number ) {
                    nextGreaterNumber = nums2[j]
                    answerArray[i] = nextGreaterNumber
                    j=nums2.size
                    continue
                }
            }

            if(nums2[j] == number) {
                position = j
                j++
            } else {
                j++
                continue
            }


        }
        i++


    }

    return answerArray


}

@RequiresApi(Build.VERSION_CODES.N)
fun nextGreaterElementt(findNums: IntArray, nums: IntArray): IntArray? {
    val map: MutableMap<Int, Int> = HashMap() // map from x to next greater element of x
    val stack = Stack<Int>()
    for (num in nums) {
        while (!stack.isEmpty() && stack.peek() < num) map[stack.pop()] = num
        stack.push(num)
    }
    for (i in findNums.indices) {
        findNums[i] = map.getOrDefault(findNums[i], -1)
    }
    return findNums
}


fun majorityElement(nums: IntArray): Int {

    var hashmap = mutableMapOf<Int, Int>()
    var value = 0

    for(i in 0 until nums.size) {

        if(hashmap.contains(nums[i])) {
            hashmap.set(nums[i], hashmap.get(nums[i])!!+1)
        } else {
            hashmap[nums[i]] = 1
        }

    }


    var returnVal = 0
    var key = 0
    for (i in hashmap.entries) {
        if(i.value > returnVal)  {
            returnVal = i.value
            key = i.key
        }
    }

    return key


}


fun major() {
    var intARray = intArrayOf(3,3,2,2,3,1,3)

    var count =1
    var answer = intARray[0]

    for (i in 1 until intARray.size) {
        if(answer != intARray[i]) {
            count--
        } else {
            count++
        }

        println(count)
        if(count == 0) {
            count = 1
            answer = intARray[i]
        }

    }



    println()
    println(answer)



}