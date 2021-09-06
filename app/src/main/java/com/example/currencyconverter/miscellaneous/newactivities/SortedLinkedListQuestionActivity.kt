package com.example.currencyconverter.miscellaneous.newactivities

class SortedLinkedListQuestionActivity {


}

 class ListNode(var `val`: Int) {
        var next: ListNode? = null

 }

fun main() {
//    val answer = ListNode(10)

    var c = ListNode(4)
    c.next =  null
    var b = ListNode(2)
    b.next = c

    var a = ListNode(1)
    a.next = b


    var f = ListNode(4)
    f.next = null
    var e = ListNode(3)
    e.next = f
    var d = ListNode(1)
    d.next = e

//    var mergeTwoLists = mergeTwoLists(a, d)

    var merge = merge(a,d)

//    while(mergeTwoLists != null) {
//        println(mergeTwoLists.`val`)
//        mergeTwoLists = mergeTwoLists.next
//    }


    while(merge != null) {
        println(merge.`val`)
        merge = merge.next
    }
}

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var l1 = l1
    var l2 = l2
    val head = ListNode(0)
    var handler: ListNode? = head
    while (l1 != null && l2 != null) {
        if (l1.`val` <= l2.`val`) {
            handler!!.next = l1
            l1 = l1.next
        } else {
            handler!!.next = l2
            l2 = l2.next
        }
        handler = handler.next
    }
    if (l1 != null) {
        handler!!.next = l1
    } else if (l2 != null) {
        handler!!.next = l2
    }
    return head.next
}


fun merge(l1: ListNode?, l2: ListNode?):ListNode? {

         if(l1== null && l2 == null) {

             return l1

         }

         if(l1 == null) {
             return l2
         }

         if(l2 == null) {
             return l1
         }


         var l1 = l1
         var l2 = l2


         val answer = ListNode(0)
         var temp:ListNode? = answer

         while(l1!= null && l2!= null) {

             if(l1.`val` > l2.`val`) {

                 temp?.next = l2
                 l2 = l2.next

                 // answer.`val` = l2.`val`
                 // temp = temp.next
                 // l1 = l1.next

             }else {

                 temp?.next = l1
                 l1= l1.next

                 // answer.`val` = l2.`val`
                 // temp = temp.next
                 // l2 = l2.next
             }

             temp = temp?.next


         }


         if(l1 != null) {


             temp?.next = l1
             // answer.`val` = l1.`val`
             // temp = temp.next
             // l1 = l1.next
         }

         if(l2 != null) {

             temp?.next = l2
             // answer.`val` = l2.`val`
             // temp = temp.next
             // l2 = l2.next
         }


         return answer.next



}