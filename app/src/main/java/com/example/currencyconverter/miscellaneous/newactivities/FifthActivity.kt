package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*

class FifthActivity {

}


fun main() {
    var array = intArrayOf(2,2,3,1)
//
//    var tree = TreeSet<Int>(array.asList())
//
//    println(thirdMax(array))



    nothing()

    var stack = Stack<Int>()





}


fun nothing () {
    var a = 1
    var b = 5


    var bb = '1'

    println(bb.digitToInt())

    var num = 10_000_000_000

    var list = LinkedList<Int>()

    list.add(1)
    list.add(2)
    list.add(3)
    list.addFirst(1)
    println(list)
}




fun thirdMax(nums: IntArray): Int {

    var tree = TreeSet<Int>(nums.asList())

    println(tree)

    if(tree.size < 3) {
        return tree.elementAt(tree.size-1)
    } else {
        return tree.elementAt(tree.size-3)
    }


}