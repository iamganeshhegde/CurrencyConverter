package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*
import kotlin.collections.ArrayList

class BucketSortActivity {


}

fun main() {
    var inArray = intArrayOf(54, 46, 83, 66, 95, 92, 43)

    val buckets: Array<List<Int>?> = arrayOfNulls<List<Int>>(10)

    var list = arrayOfNulls<MutableList<Int>>(10)/*(ArrayList<Int>(10))*/


    var a  = LinkedList<Int>()

    for (i in 0 until list.size) {
        list[i] = ArrayList()
    }

    for(i in 0 until inArray.size) {
        list[hash(inArray[i])]?.add(inArray[i]) /*.add(inArray[i])*/
    }

    for (bucket in list) {
        bucket?.sort()
    }

    var j=0
    for (i in 0 until list.size) {
        for (value in list[i]!!) {
            inArray[j++] = value
        }
    }

    inArray.iterator().forEach {
        println(it)
    }

}


fun hash(value:Int): Int {
    return value / 10
}