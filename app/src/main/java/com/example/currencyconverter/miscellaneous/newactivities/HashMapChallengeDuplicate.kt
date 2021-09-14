package com.example.currencyconverter.miscellaneous.newactivities

class HashMapChallengeDuplicate {
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