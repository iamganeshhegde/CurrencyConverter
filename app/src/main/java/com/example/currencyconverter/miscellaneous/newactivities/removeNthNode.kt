package com.example.currencyconverter.miscellaneous.newactivities

class removeNthNode {
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