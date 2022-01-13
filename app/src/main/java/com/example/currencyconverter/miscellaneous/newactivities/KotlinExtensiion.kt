package com.example.currencyconverter.miscellaneous.newactivities

open class KotlinExtensiion

//open class Animal
open class Dog/*: Animal()*/

fun Dog.say(/*a:Animal*/) {
    println("I am dog")
}

//fun Animal.say() {
//    println("I am Animal")
//}


fun main() {
    var dog = Dog()
    dog.say(/*dog*/)


}