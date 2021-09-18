package com.example.currencyconverter.adobeInterview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.R
import java.util.*


class FirstMainActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first_main)
    }


}

fun main() {


//    var intersection = intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))
//
//    intersection.iterator().forEach {
//        println(it)
//    }


    var findWords = findWords(arrayOf("Hello"))
    findWords.iterator().forEach {
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


fun findWords(words: Array<String>): Array<String> {
    val strs = arrayOf("QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM")
    val results: MutableList<String> = ArrayList<String>()
    for (word in words) {
        var count1 = 0
        var count2 = 0
        var count3 = 0
        for (c in word.toCharArray()) {
            if (strs[0].lowercase().indexOf(c) != -1) count1++
            if (strs[1].lowercase().indexOf(c) != -1) count2++
            if (strs[2].lowercase().indexOf(c) != -1) count3++
        }
        if (count1 == 0 && count2 == 0 || count1 == 0 && count3 == 0 || count2 == 0 && count3 == 0) results.add(
            word
        )
    }
    return results.toTypedArray()
}


fun findWordss(words: Array<String>): Array<String>? {
    val strs = arrayOf("QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM")
    val map: MutableMap<Char, Int> = HashMap()
    for (i in strs.indices) {
        for (c in strs[i].toCharArray()) {
            map[c] = i //put <char, rowIndex> pair into the map
        }
    }
    val res: MutableList<String> = LinkedList()
    for (w in words) {
        if (w == "") continue
        var index = map[w.toUpperCase()[0]]!!
        for (c in w.toUpperCase().toCharArray()) {
            if (map[c] != index) {
                index = -1 //don't need a boolean flag.
                break
            }
        }
        if (index != -1) res.add(w) //if index != -1, this is a valid string
    }
    return res.toTypedArray()
}