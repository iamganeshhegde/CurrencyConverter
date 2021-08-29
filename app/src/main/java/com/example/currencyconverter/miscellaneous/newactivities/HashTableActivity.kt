package com.example.currencyconverter.miscellaneous.newactivities

import com.example.currencyconverter.miscellaneous.model.Employee

class HashTableActivity {
}

fun main() {

    var map = HashMap<Int, Int>()
    var mutemap = mutableMapOf<Int, Int>()

    var ganesh = Employee(123, "Ganesh", "Hegde")
    var rama = (Employee(456,"Rama", "Hegde"))
    var bharati =  Employee(789,"Bharati", "Hegde")

    var hashTable = SimpleHashTable()


    hashTable.put("ganesh", ganesh)
    hashTable.put("rama", rama)
    hashTable.put("bharati", bharati)

    var ganess = Employee(123, "ganess", "Hegde")


    hashTable.put("ganess", ganess)

    hashTable.print()
    println()

    println(hashTable.get("ganess"))

    println()

    println(hashTable.remove("ganesh"))
    println()

    hashTable.print()

    println()

//    println(hashTable.get("ganess"))
    println(hashTable.get("ganesh")?:"No element")

}