package com.example.currencyconverter.miscellaneous.newactivities

import io.reactivex.Completable
import io.reactivex.Maybe
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


    Maybe.create<String> {
        it.onSuccess("Ganesh hegde Maybe")
    }.subscribe ({
        println(it)
    },{
      println("Errror")
    }, {
        println("Complete")
    })


    Completable.create {
        it.onComplete()
    }.subscribe ({
        println("Complete")
    },{

    })

}