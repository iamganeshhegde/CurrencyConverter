package com.example.currencyconverter

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.currencyconverter.miscellaneous.TrimDelegate
import com.example.currencyconverter.miscellaneous.activities.SecondActivity
import com.example.currencyconverter.viewmodel.RandomViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity() {
    var akkk = 5888
    var abcd: String = "123"


    private val model: RandomViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_CurrencyConverter_NoActionBar);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var akkk = "aaa"

        abcd.toInt()

        var split = akkk.toString().split("")


        val statusObserver = Observer<String> {

            txtContact.text = it
        }


        model.status.observe(this, statusObserver)


    }



    var canvas = Canvas()

    private val textPaint =
        Paint().apply {
            isAntiAlias = true
            color = Color.RED
            style = Paint.Style.STROKE
        }


}

fun handleOnBackPressed(): Boolean {
    var a = true

    return (a!= true).also {
        a.toString()
    }


    return if (a != true) {
        a.toString()
//        navigationView.selectHomeDestination()
        true
    } else {
        false
    }
}

private fun Boolean.call(): Unit {
    a.toString()
}

var a: click = { a, b ->
    a + b
}

var b: clicked = { a ->
        c
}

var c: clickedtwice = { a ->
    a+10
}


fun main() {

    SecondActivity().a()

//    val items = listOf(1, 2, 3, 4, 5)
//    var fold = items.fold(1, Int::plus)
//
//    println(fold)


//
    var newString :String by TrimDelegate()
    newString = "Ganesh"
    var a:Int? = 0

    var delegeate:String by Del()


    delegeate = "Ganesh "
    println(delegeate)

    println(newString)
//
//    var b = a?.also {
//        println("abcd")
//        10
//    }?: run {
//        println("cdba")
//        20
//    }
//
//
//
//
//    println(b)


//    newString = "    Ganesh    "
//    println(newString)

//    println(a.invoke(1, 2))
//    println(b.invoke(5))
//    println(b(5))
//
//
//    println(sum(10,2))



//    Reverse number
//    var num = 1024
//    println(reverse(num))


//    println(maxSubArray(intArrayOf(1,5,-8,-1,-4)))

    lengthOfLastWord("   First Second   Last")

}

var answer = 0
fun reverse(num: Int): Int {

    if(num == 0) {
        return answer
    }


    if(num > 0) {

        var temp = num%10

        answer = answer * 10+temp

        reverse(num/10)

    }


    return answer


}


fun maxSubArray(A: IntArray): Int {
    var maxSoFar = A[0]
    var maxEndingHere = A[0]
    for (i in 1 until A.size) {

        maxEndingHere = if(maxEndingHere+A[i] < A[i]) {
            A[i]
        } else {
            maxEndingHere+A[i]
        }

        maxSoFar = if(maxEndingHere < maxSoFar) {
            maxSoFar
        } else {
            maxEndingHere
        }

//        maxEndingHere = Math.max(maxEndingHere + A[i], A[i])
//        maxSoFar = Math.max(maxSoFar, maxEndingHere)
    }
    return maxSoFar
}



fun lengthOfLastWord(s: String): Int {

    var newString =  s.trim()

    var delim = " +".toRegex()
    var array = newString.split(delim)
    var maxSize = 0

    println(newString)
    println(array.size)

    for(i in array.indices) {
        println(array[i])


        maxSize = array[i].length

    }

    return maxSize


}




typealias event = Int.(a: Int) -> Unit



//typealisases are like interfaces but with the lambda functions
//click function takes a and b which are integers as parameters and returns an integer( after -> )
typealias click = (a: Int, b: Int) -> Int
typealias clicked = (a: Int)  -> ((b: Int) -> Int)
typealias clickedtwice = (a: Int)  -> Int


//println(sum(10,2))
//function literals where (other:Int - 2) is a parameter with receiver type Int - 10
// 'this' is the reference to 10(Int) and other is a parameter
var sum  = fun Int.(other:Int) : Int = this+other


class Del:ReadWriteProperty<Any?, String> {

    var aluee =""

    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return aluee
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        aluee = value+"hello"

    }



}