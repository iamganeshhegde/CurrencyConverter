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

fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    for (n in nums) if (i < 2 || n > nums[i - 2]) nums[i++] = n
    return i
}