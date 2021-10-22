package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*


class TestActivity {




}

fun main() {


    println(rotate(23456))


    //    Calendar calendar = Calendar.getInstance();
    //    int count = 0;
    //for(int i=1901;i<2000;i++){
    //        for(int j=1;i<12;j++){
    //            calendar.set(Calendar.YEAR, i);
    //            calendar.set(Calendar.MONTH,j);
    //            calendar.set(Calendar.DATE,1);
    //            if(calendar.get(Calendar.DAY_OF_WEEK) == (Calendar.SUNDAY)){
    //                count++;
    //            }
    //        }
    //    }
//    println(maxTickets(arrayListOf(5,10,12,1,10,4)))



//    println(addStrings("11","111"))



//    var a = "11"
//    var b = "22"
//
//    println(a.toInt()+b.toInt())

}


fun maxTicketss(tickets: List<Int>): Int {
    var answer = 1
    val numberOfelemnets = tickets[0]
    var max = 0
    var answerArray: List<Int> = ArrayList()
    answerArray = tickets.subList(1, tickets.size)
    Collections.sort(answerArray)
    var current = answerArray[0]
    for (i in 1 until answerArray.size) {
        if (answerArray[i] === current || answerArray[i] == current + 1) {
            answer = answer + 1
        } else if (answerArray[i] > current + 1) {
            answer = 1
        }
        if (max < answer) {
            max = answer
        }
        current = answerArray[i]
    }
    return max
}


fun maxTickets(tickets: List<Int>): Int {
    var answer = 1
    val numberOfelemnets = tickets[0]
    var max = 0
    var answerArray: List<Int> = ArrayList()
    answerArray = tickets.subList(1, tickets.size)
    Collections.sort(answerArray)
    var current = answerArray[0]
    for (i in 1 until answerArray.size) {
        if (answerArray[i] === current || answerArray[i] == current + 1) {
            answer = answer + 1
        } else if (answerArray[i] > current + 1) {
            answer = 1
        }
        if (max < answer) {
            max = answer
        }
        current = answerArray[i]
    }
    return max
}



//    Calendar calendar = Calendar.getInstance();
//    int count = 0;
//for(int i=1901;i<2000;i++){
//        for(int j=1;i<12;j++){
//            calendar.set(Calendar.YEAR, i);
//            calendar.set(Calendar.MONTH,j);
//            calendar.set(Calendar.DATE,1);
//            if(calendar.get(Calendar.DAY_OF_WEEK) == (Calendar.SUNDAY)){
//                count++;
//            }
//        }
//    }



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



fun rotate(n:Int): Int {

    var nn = ""+n

    var n2 = nn[nn.length-1]+nn.substring(0,nn.length-1)
    return n2.toInt()


}


fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var c1 = l1
    var c2 = l2
    val sentinel = ListNode(0)
    var d: ListNode? = sentinel
    var sum = 0
    while (c1 != null || c2 != null) {
        sum /= 10
        if (c1 != null) {
            sum += c1.`val`
            c1 = c1.next
        }
        if (c2 != null) {
            sum += c2.`val`
            c2 = c2.next
        }
        d!!.next = ListNode(sum % 10)
        d = d.next
    }
    if (sum / 10 == 1) d!!.next = ListNode(1)
    return sentinel.next
}