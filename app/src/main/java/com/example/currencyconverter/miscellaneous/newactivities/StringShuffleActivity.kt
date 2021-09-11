package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Build
import androidx.annotation.RequiresApi
import io.reactivex.Single

class StringShuffleActivity {
}

@RequiresApi(Build.VERSION_CODES.O)
fun main() {

//    println(sortSentence("is2 sentence4 This1 a3"))
//    println(sortSentencee("is2 sentence4 This1 a3"))








}

fun sortSentence(s: String): String {

    var string = s.split(" ")
    var answerString = s
    var array = Array<String>(string.size){
        ""
    }
    var answer = ""


    string.listIterator().forEach {
        println(it)
    }


    for (str in string) {
        var last = str.length-1

//        answer +=

    }


    string.sortedBy {
        it[it.length-1]
    }


    println()

    string.listIterator().forEach {
        println(it)
    }








//    for (i in 0 until string.size) {
////        array[string[i].get(string[i].length-1).digitToInt()] = string[i].get(string[i].length-1).toString()
//        array[string[i].get(string[i].length-1).digitToInt()] = s.substring(0,string[i].length-1)
//
//    }






//    for (i in 0 until string.size) {
//
//        answerString = string[i].get(string[i].length-1).digitToInt()
//    }


////    array.sort()
//
//    println()
//    array.iterator().forEach { println(it) }
//    println()
//
//    for (i in 0 until array.size) {
//
//        answer += string[array[i].toInt() -1]
//
//        answer = answer.dropLast(1)+" "
//
//    }
//
//    return answer.trim()

    return ""

}

@RequiresApi(Build.VERSION_CODES.O)
fun sortSentencee(s: String): String? {
    val words = s.split(" ").toTypedArray()
    val ans = arrayOfNulls<String>(words.size)
    for (word in words) {
        val i = word.length - 1
        ans[word[i] - '1'] = word.substring(0, i)
    }
    return java.lang.String.join(" ", *ans)
}