package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Bundle
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity

class HashMapChallengeDuplicate:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

}

fun main(){

}

fun containsDuplicate(nums: IntArray): Boolean {

    var hashmap = mutableMapOf<Int, Int>()


    for(i in 0 until nums.size) {

        if(hashmap[nums[i]] == nums[i]) {
            return false
        } else {
            hashmap[nums[i]] = nums[i]
        }

    }

    return true


}