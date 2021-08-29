package com.example.currencyconverter.miscellaneous.newactivities

import com.example.currencyconverter.miscellaneous.model.Employee

class SimpleHashTable {

    var hashtable = arrayOfNulls<StoredEmployee>(10)


    fun hashkey(key: String): Int {
        return key.length % hashtable.size
    }

    fun put(key: String, employee: Employee) {
        var hashedKey = hashkey(key)

        var stopIndex = hashedKey


        if (occupied(hashedKey)) {
            if (hashedKey < hashtable.size) {
                hashedKey++
            } else {
                hashedKey = 0
            }
        }

        while (hashedKey != stopIndex && occupied(hashedKey)) {
            hashedKey++
        }

        if (hashtable[hashedKey] != null) {
            println("Sorry, there is an employee at that position $hashedKey")
        } else {
            hashtable[hashedKey] = StoredEmployee(key, employee)
        }
    }

    fun occupied(key: Int): Boolean {
        return hashtable[key] != null
    }


    fun get(key: String): Employee? {
        var hashedKey = hashkey(key)



        var newKey = findKey(hashedKey, key)
        if(newKey == -1) {
            return null
        }
        return hashtable[newKey]?.emplyee



    }

    fun findKey(hashedKey:Int, key: String):Int {

        var stopIndex = hashedKey

        var newwKey = hashedKey
        if (occupied(hashedKey) && hashtable[hashedKey]?.key.equals(key)) {
            return hashedKey

        } else {
            if (newwKey < hashtable.size) {
                newwKey++
            } else {
                newwKey = 0
            }
        }

        while (newwKey != stopIndex && occupied(newwKey) && !hashtable[newwKey]?.key.equals(
                key
            )
        ) {
            newwKey = (newwKey + 1) % hashtable.size
        }


        return if (hashtable[newwKey] == null || !hashtable[newwKey]?.key.equals(key)) {
            println("Sorry, there is no employee at that position $newwKey")
            -1
        } else {
            newwKey
        }
    }


    fun remove(key:String): Employee? {
        var hashedkey = hashkey(key)


        var keyyy = findKey(hashedkey, key)


        if(keyyy == -1) {

            return null
        }

        var employee = hashtable[keyyy]?.emplyee
        hashtable[keyyy] = null

        return employee


    }

    fun print() {
        for (i in hashtable.indices) {
            println(hashtable[i]?.emplyee)
        }
    }

}