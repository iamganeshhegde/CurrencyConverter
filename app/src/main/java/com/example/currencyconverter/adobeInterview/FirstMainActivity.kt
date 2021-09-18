package com.example.currencyconverter.adobeInterview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.R

class FirstMainActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first_main)
    }


}

fun main() {


    var intersection = intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))

    intersection.iterator().forEach {
        println(it)
    }

}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {

    var hashSet = hashSetOf<Int>()
    var intArray = mutableListOf<Int>()


    for(i in 0 until nums1.size) {
        hashSet.add(i)
    }

    for(i in 0 until nums2.size) {
        if(hashSet.contains(nums2[i])) {
            if(intArray.contains(nums2[i]).not()) {
                intArray.add(nums2[i])
            }

        }
    }

    return intArray.toIntArray()

}