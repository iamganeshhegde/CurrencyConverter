package com.example.currencyconverter.miscellaneous.newactivities

class TestActivity {




}

fun main() {

    println(addStrings("11","111"))



//    var a = "11"
//    var b = "22"
//
//    println(a.toInt()+b.toInt())

}

//fun stringbuilder {
//    var i: Int = num1.length() - 1
//    var j: Int = num2.length() - 1
//
//    val sb = StringBuilder()
//    var carry = 0
//
//    while (i >= 0 || j >= 0 || carry > 0) {
//        var n1 = 0
//        var n2 = 0
//        if (i >= 0) {
//            n1 = num1.charAt(i) - '0'
//            i--
//        }
//        if (j >= 0) {
//            n2 = num2.charAt(j) - '0'
//            j--
//        }
//        val num = (n1 + n2 + carry) % 10
//        carry = if (n1 + n2 + carry >= 10) 1 else 0
//        sb.append(num)
//    }
//
//
//    return sb.reverse().toString()
//
//}


fun addStrings(num1: String, num2: String): String {

    var numberFirst = num1
    var numberSecond = num2

    var i=num1.length -1
    var j=num2.length -1
    var carry = 0

    var sum =0
    var string = StringBuilder()

    while(i >= 0 || j >= 0 || carry >0) {


        var first = 0
        var second = 0

        if(i >= 0){
            first = num1[i] - '0'
            i--
        }

        if(j >=0) {
            second = num2[j] - '0'
            j--
        }

        var num = (first + second + carry) %10

        carry = if(first + second + carry >= 10 ) 1 else 0



        string.append(num)

    }

    return string.reverse().toString()


//    while(i >= 0) {
//
//        sum = sum+numberFirst[i].toInt()
//        i--
//
//    }
//
//    while(j >= 0) {
//        sum =sum+numberSecond[j].toInt()
//        j--
//    }


    return sum.toString().reversed()

}