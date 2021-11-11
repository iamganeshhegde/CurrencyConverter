package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Build
import androidx.annotation.RequiresApi

class FirstUniqueCharacter {
}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {

    var s = "leetcode"
    var first = 0
    var map  = mutableMapOf<Char, Int>()

    map.put(s[0],1)

    for (i in 0 until s.length) {
        map.put(s[i], map.getOrDefault(s[i]+1,1) )

        if(map[s[i]]!! > 1) {
            first=-1
        }

        if(first == -1 && map[s[i]]!! == 1) {
            first = i
        }
    }

}

@RequiresApi(Build.VERSION_CODES.N)
fun isAnagram(s: String, t: String): Boolean {

    var hashmap = mutableMapOf<Char,Int>()

    for(i in 0 until s.length) {
        hashmap.put(s[i], hashmap.getOrDefault(s[i],0)+1)
    }

    for(i in 0 until t.length) {
        if(hashmap.contains(t[i]) && hashmap[t[i]]!! >= 1 ) {
            hashmap.put(t[i], hashmap.get(t[i])!!-1)
        } else {
            return false
        }
    }


    return true
}