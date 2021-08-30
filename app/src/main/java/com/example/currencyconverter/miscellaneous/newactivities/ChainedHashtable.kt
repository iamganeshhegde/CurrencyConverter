package com.example.currencyconverter.miscellaneous.newactivities

import com.example.currencyconverter.miscellaneous.model.Employee
import java.util.*
import kotlin.math.abs

class ChainedHashtable {


    private var hashTable: Array<LinkedList<StoredEmployee>?> = arrayOfNulls<LinkedList<StoredEmployee>>(10)
    fun hashkey(key: String): Int {
//        return key.length % hashTable.size
        return abs(key.hashCode()) % hashTable.size
    }

    init {
        for (i in 0 until hashTable.size) {
            hashTable[i] = LinkedList()
        }

    }


    fun put(key:String, employee: Employee) {

        var hashedKey = hashkey(key)

        hashTable[hashedKey]?.add(StoredEmployee(key,employee))
    }


    fun get(key: String): Employee? {
        var hashedKey = hashkey(key)

        var iterator = hashTable[hashedKey]?.iterator()

        var employee: StoredEmployee? = null
        while (iterator?.hasNext() == true) {

            employee = iterator.next()
            if(employee.key == key) {
                return employee.emplyee
            }
        }


        return null
    }

    fun remove(key: String): Employee? {
        var hashedKey = hashkey(key)

        var iterator = hashTable[hashedKey]?.iterator()

        var employee: StoredEmployee? = null
        var index=-1
        while (iterator?.hasNext() == true) {

            employee = iterator.next()
            index++
            if(employee.key == key) {
                break
            }
        }

        if(employee == null) {
            return null
        } else {
            hashTable[hashedKey]?.removeAt(index)
            return employee.emplyee
        }

    }

    fun print() {
        for (i in 0 until hashTable.size) {
            if(hashTable[i]?.isEmpty() == true) {
                println("Empty link")
            } else {
                println("Position $i")
                var iter = hashTable[i]?.iterator()

                while (iter?.hasNext() == true) {
                    print("${iter.next().emplyee}  ->")
                }

                println()

            }
        }
    }


}