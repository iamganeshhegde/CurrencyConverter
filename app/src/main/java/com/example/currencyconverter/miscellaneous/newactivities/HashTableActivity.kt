package com.example.currencyconverter.miscellaneous.newactivities

import com.example.currencyconverter.miscellaneous.model.Employee

class HashTableActivity {
}

fun main() {

//    var map = HashMap<Int, Int>()
//    var mutemap = mutableMapOf<Int, Int>()
//
    var ganesh = Employee(123, "Ganesh", "Hegde")
    var rama = (Employee(456,"Rama", "Hegde"))
    var bharati =  Employee(789,"Bharati", "Hegde")


        var ganess = Employee(123, "ganess", "Hegde")

//
//    var hashTable = SimpleHashTable()
//
//
//    hashTable.put("ganesh", ganesh)
//    hashTable.put("rama", rama)
//    hashTable.put("bharati", bharati)
//
//    var ganess = Employee(123, "ganess", "Hegde")
//
//
//    hashTable.put("ganess", ganess)
//
//    hashTable.print()
//    println()
//
//    println(hashTable.remove("ganesh"))
//    println()
//
//    hashTable.print()
//    println()
//
//    println(hashTable.remove("bharati"))
//    println()
//
//    hashTable.print()
//
//

//    println(hashTable.get("ganess"))




    var chainedHashtable:ChainedHashtable = ChainedHashtable()

    chainedHashtable.put("ganesh", ganesh)
    chainedHashtable.put("ganess", ganess)
    chainedHashtable.put("rama", rama)
    chainedHashtable.put("bharati", bharati)


    chainedHashtable.print()


//    println(chainedHashtable.get("ganess"))
//
//    println()
//    println(chainedHashtable.remove("ganess"))
//
//    println()
//    chainedHashtable.print()
//
//
//    println(chainedHashtable.get("ganesh"))
//

}