package com.example.currencyconverter.miscellaneous.activities

class ListDeleteDuplicate {
}

fun main() {

    var head = li
    li.next = ListNode(1)
    li.next!!.next = ListNode(2)


    deleteDuplicates(head).also {
        println(it?.next)
    }

}

var li = ListNode(1)
var v = li.`val`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    var head = head

    var temp = head
    var answer = temp

    while(temp != null) {
        if(temp.next == null) {
            break
        }

        if(temp.`val` == temp.next!!.`val`) {
            temp.next= temp.next!!.next
        } else {
            temp= temp.next
        }

    }

    return head

}