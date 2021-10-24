package com.example.currencyconverter.miscellaneous.newactivities

import android.app.ActivityManager
import android.app.ListActivity
import android.bluetooth.BluetoothClass
import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.ListFragment
import java.util.prefs.Preferences

class ShareTest:ListActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        var a = BluetoothClass.Major.

//        var a  = ActivityManager.


    }

//    override fun onContextItemSelected(item: MenuItem): Boolean {
////        return super.onContextItemSelected(item)
//
////        var value:AdapterView.AdapterContextMenuInfo =  item.menuInfo as AdapterView.AdapterContextMenuInfo
////
////        var bundle = Bundle()
////        var id:Int = 0
////        bundle.putString("id",id)
////    }
////}
//    }
}

fun main() {
//    println(TestClass().main())

//    var text:String = "Share"
//    text = null



//    val test = Test()
//    test.score = 10
//    println(test.score!!)
//    println("Score")



//    val a =20
//    a=10






}

class Test() {
//    sharechat
    var score:Int? = null
        get() {
            return if (score != null && score!! < 0)
                0
            else
                score
        }


}

class TestClass(var a:Int=10) {

    lateinit var test:TestClass

    fun main() {
        println(test.a)
    }
}

//class Fragments:CursorFr