package com.example.currencyconverter.miscellaneous.newactivities

class Name100Activity {

}

fun main() {
    var name = "Ganesh \n"

    var array = arrayOf(name)


//    print(String.format("%010d",0).replace("0","Ganesh\n"));


//    println(String.format("%010d", 777).replace('0', '*'))
    println(String.format("%$10d", 777).replace('0', '*')) // not usable


    var string = "Hello/gg/jj/"
    string = string.replace(Regex("/$"), "")

    println(string)

    var link = "aaa/bbb/cc/"

//    link = link.replaceAll("/$", "");




}
fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    var ans = 0
    var max = 0
    for (i in timeSeries) {
        if (i < max) {
            ans += i + duration - max
            max = i + duration
        } else {
            ans += duration
            max = i + duration
        }
    }
    return ans
}

//fun removeElements(head: ListNode, `val`: Int): ListNode? {
//    val dummy = ListNode(0)
//    dummy.next = head
//    var cur: ListNode = dummy
//    while (cur.next != null) {
//        if (cur.next.`val` === `val`) {
//            cur.next = cur.next.next
//        } else cur = cur.next
//    }
//    return dummy.next
//}