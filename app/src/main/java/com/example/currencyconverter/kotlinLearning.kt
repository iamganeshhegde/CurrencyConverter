package com.example.currencyconverter

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class kotlinLearning:AppCompatActivity() {


    var handler = Handler(Looper.getMainLooper()) { it ->
        println(it)
        true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.show()

    }




}

class HandlerT :HandlerThread("Handler") {

    override fun onLooperPrepared() {
        super.onLooperPrepared()


    }

    override fun run() {
        super.run()



    }


}

class IntService:IntentService("aaa"){
    override fun onHandleIntent(intent: Intent?) {



    }

}

fun main() {

    //lambda
    var sum: (Int,Int) -> Int = {a:Int, b:Int -> a+b}

    var sameSum = {a:Int, b:Int -> a+b}


    var a = { a: Int, b: Int -> a + b }

    val stringPlus : (String,String) -> String =  String::plus
//
//    val stringPlus: (String, String) -> String = String::plus

    println(stringPlus.invoke("a","b"))
    println(stringPlus("a","b"))




    println(a.invoke(10, 20))

    var ll: summer = { it->

//        println(it)
        it+10

    }

    println(ll)






    //anonymous
    fun(x:Int, y:Int):Int = x+y


    var ints = intArrayOf(1,2,3,0,-1)
    ints.filter(fun(item) = item>0 ).iterator().forEach { println(it) }



    var summm  = fun Int.(other:Int) : Int = this+other


    var summmm = 10.addd(10)




}

fun Int.addd(i: Int): Any {
    return this+i
}

fun Context.show(){
    Toast.makeText(this,"aa",Toast.LENGTH_SHORT).show()
}






typealias summer = (a: Int) -> Int