package com.example.currencyconverter.miscellaneous.newactivities

class ReflectionCheck {
}

class Company(private val companyName: String) {
    private val nameLength = companyName.length
}

//val c = Company("Medium")
//
//val nl = Company::class.memberProperties.find { it.name == "nameLength"}
//nl?.let {
//    it.isAccessible = true //toggle visibility of private field
//    val length = it.get(c) as Int
//    println("Name has $length characters")
//}