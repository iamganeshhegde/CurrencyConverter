package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Build
import androidx.annotation.RequiresApi

class removeNthNode {
}


@RequiresApi(Build.VERSION_CODES.N)
fun main() {
//    println(toString("Kotlin"))
//
//    var map = mapOf("Dog" to 16, "aa" to 3, "bir" to 19)
//
//    map.forEach(fun(_,value) {
//
//        println(value)
//    })



//    var p = Painting("Red", "Green", "Blue")
//    p.prinT()

    println(countValidWords("Ganesh Hegde      hi"))




}
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

    var start = ListNode(0)
    var fast = start
    var slow = start

    start.next = head

    for(i in 1 until n+1) {

        fast = fast.next!!

    }

    while(fast.next != null) {
        slow = slow.next!!
        fast = fast.next!!
    }


    slow.next = slow.next!!.next
    return start.next

}

fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    for (n in nums) if (i < 2 || n > nums[i - 2]) nums[i++] = n
    return i
}

fun toString(x:Any) :String {
    return when(x) {
        is Int -> x.div(3).toString()
        is String ->x.toLowerCase()
        is Long -> x.plus(2).toString()
        else ->"Invalid"
    }
}


class Painting private constructor(var color1:String, col2:String) {
    fun prinT() {
        println(color1)
    }

    constructor(color1: String,col2: String,colour3:String):this(color1,col2){

        this.color1 = colour3
    }
}


class b{
    var a :String
    constructor(a:String) {
        this.a = a
    }
}

open class animal(){

    open fun a(){

    }
}

class d:animal() {

    fun b() {
        super.a()
    }
}

fun printspecialElements(arr: Array<String>) {
    for (i in arr.indices) {
        if (arr[i].toInt() % 11 == 0) {
            println(arr[i])
        }
    }
}

fun countValidWords(sentence: String): Int {

    var array = sentence.split(" +".toRegex())
//    var array = sentence.split("\\s".toRegex())
    var count = 0

    for(word in array) {
        if(word.contains(".*\\d.*".toRegex())) {

        } else if(word.all { it.isLetter() }) {
            count++
        } else {
            if(word.last().isLetter() && word.first().isLetter()) {
                count++
            }
        }
    }
    array.iterator().forEach { println(it) }

    return count

}

fun countValidWordsss(sentence: String): Int {
    val str = sentence.split(" ").toTypedArray()
    var res = 0
    for (s in str) {
        if (s != "" && isValid(s)) {
            res++
        }
    }
    return res
}

fun countValidWordss(sentence: String): Int {
    val str = sentence.split(" ").toTypedArray()
    var res = 0
    for (s in str) {
        if (s != "" && isValid(s)) {
            res++
        }
    }
    return res
}

fun isValid(s: String): Boolean {
    var h = 0
    var m = 0
    val ch = s.toCharArray()
    for (i in ch.indices) {
        if (Character.isDigit(ch[i]) || ch[i] == ' ') {
            return false
        }
        if (ch[i] == '-') {
            h++
            if (h >= 2) return false else if (i == 0 || i == ch.size - 1 || !Character.isLetter(
                    ch[i - 1]
                ) || !Character.isLetter(ch[i + 1])
            ) return false
        }
        if (ch[i] == '!' || ch[i] == '.' || ch[i] == ',') {
            m++
            if (m >= 2) return false
            if (i != ch.size - 1) return false
        }
    }
    return true
}
