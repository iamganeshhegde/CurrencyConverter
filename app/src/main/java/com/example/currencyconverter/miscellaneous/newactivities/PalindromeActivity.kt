package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*

class PalindromeActivity {
}

fun main() {
//    var string = "rac e : car"
//
//    var regex = Regex("[^A-Za-z0-9]")
//    var replace = regex.replace(string, "")
////    string.replace("".toRegex(),"")
//
//
////    string.replace("[^A-Za-z0-9]","")
//
//
//
//    println(replace)



    println(isPalindrome("A man, a plan, a canal: Panama"))



}


fun isPalindrome(s: String): Boolean {

    var string = s
    var regex = Regex("[^A-Za-z0-9]")
    var replace = regex.replace(string,"").lowercase(Locale.getDefault())

    var i=0
    var j=replace.length-1

    println(replace)

    while(i < j) {
        if(replace[i].equals(replace[j])) {
            i++
            j--
        } else {
            return false
        }
    }

    return true

}