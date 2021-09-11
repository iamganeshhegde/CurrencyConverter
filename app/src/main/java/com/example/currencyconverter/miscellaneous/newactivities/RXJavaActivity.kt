package com.example.currencyconverter.miscellaneous.newactivities

import io.reactivex.Single

class RXJavaActivity {
}

fun main(){


    Single.create<String> {
        it.onSuccess("Ganesh")
    }.subscribe ({
        println(it)
    },{

    })




}