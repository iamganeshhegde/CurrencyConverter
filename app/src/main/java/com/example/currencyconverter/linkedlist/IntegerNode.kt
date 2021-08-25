package com.example.currencyconverter.linkedlist

 class IntegerNode(value: Int?) {
     var value: Int? = null
     set(value) {
         field = value
     }
    var next: IntegerNode? = null




    override fun toString(): String {
        return value.toString()
    }
}