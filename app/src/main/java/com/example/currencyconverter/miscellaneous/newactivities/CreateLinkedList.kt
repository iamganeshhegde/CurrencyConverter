package com.example.currencyconverter.miscellaneous.newactivities

class CreateLinkedList {

    var next : Node? = null
    var head:Node? = null
    var data :Int = 0

    fun insert(data:Int) {
        var node = Node(data)

        if(head == null) {
            head = node
        } else {
            var current = head
            while (current?.next !== null) {
                current = current?.next
            }

            current?.next = node

        }
    }

    fun print() {
        var current = head
        while (current != null) {
            println(current!!.value)
            current = current.next
        }
    }


}
data class Node(var value:Int, var next: Node? = null)


fun main() {
    var list = CreateLinkedList()

    list.insert(1)
    list.insert(2)
    list.insert(3)
    list.insert(8)


//    list.print()
//
//    reverseArray()

    itemChanged()
}



fun reverseArray() {
    var array = intArrayOf(1,2,3,4,5,6,7,8,9)

    var a:((Int,Int) ->Int) = {first:Int, second:Int -> first+second }

    println(a(10,20))

}


fun itemChanged() {
    var arraylist = mutableListOf<Int>(5,9,2,3,4,5,6,7,8)


    arraylist.forEachIndexed { index, i ->
        print(index)

        println(i)
    }





}