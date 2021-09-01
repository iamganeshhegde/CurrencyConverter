package com.example.currencyconverter.miscellaneous.newactivities

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.currencyconverter.miscellaneous.model.Employee
import java.util.*

class HashTableActivity {
}

@RequiresApi(Build.VERSION_CODES.N)
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


    //chained (Linked list inside a array for storing values)


//    var chainedHashtable:ChainedHashtable = ChainedHashtable()
//
//    chainedHashtable.put("ganesh", ganesh)
//    chainedHashtable.put("ganess", ganess)
//    chainedHashtable.put("rama", rama)
//    chainedHashtable.put("bharati", bharati)
//
//
//    chainedHashtable.print()


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


    //JDK implementation

    var map = mutableMapOf<String, Employee>()

    map.put("bharati", bharati)

    map.put("ganesh", ganesh)
    map.put("rama", rama)


//    var iterator = map.values.iterator()
//
//    while (iterator.hasNext()) {
//        println(iterator.next())
//    }


    println(map.containsKey("ganesh"))
    println(map.containsValue(rama))


//    println(map.put("ganesh", ganess))


    println(map.putIfAbsent("ganesh", ganess))




    println()

    println(map.get("bharati"))

    println(map.getOrDefault("ggg",ganesh))


    println()

    println(map.remove("ganesh"))

    println()


    map.forEach {
        println(it.value)
    }

    var hashtable = Hashtable<String, Int>()

}