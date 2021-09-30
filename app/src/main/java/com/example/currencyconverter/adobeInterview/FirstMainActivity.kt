package com.example.currencyconverter.adobeInterview

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.R
import com.example.currencyconverter.miscellaneous.serviceLearning.BoundService
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.activity_first_main.*
import kotlinx.android.synthetic.main.activity_first_main.startService
import kotlinx.android.synthetic.main.activity_first_main.stopService
import java.util.*


class FirstMainActivity : AppCompatActivity() {

    lateinit var oundService: BoundService
    var serviceBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first_main)

//        this.cacheDir.deleteRecursively()


        startService.setOnClickListener {
            if(serviceBound) {
                timestamp_text.text = oundService.getTimeStamp()
            }
        }


        stopService.setOnClickListener {
            if(serviceBound) {
                unbindService(serviceConnection)
                serviceBound = false
            }

            var intent = Intent(this, BoundService::class.java)
            stopService(intent)
        }



    }

    override fun onStart() {
        super.onStart()

        var intent = Intent(this, BoundService::class.java)
        startService(intent)

        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        if(serviceBound) {
            unbindService(serviceConnection)
            serviceBound = false
        }
    }

    var serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            serviceBound = true
            var mBinder:BoundService.MyNewBinder = service as BoundService.MyNewBinder
            oundService = mBinder.service
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            serviceBound = false
        }

    }

}


//    companion object{
//
//    }
//
//    object abc {
//        fun a() {
//
//        }
//    }



fun main() {

//    FirstMainActivity.abc.a()

//    var intersection = intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))
//
//    intersection.iterator().forEach {
//        println(it)
//    }

//    var first = intArrayOf(1,9,3,4)
//    var second = intArrayOf(8,7,6,5)
//
//    var nest = arrayOf(intArrayOf(1,2,3), intArrayOf(7,1,9), intArrayOf(7,3,5), intArrayOf(5,6,7))
//
//
//    Arrays.sort(nest){
//        one,two -> one[1]- two[1]
//    }
//
//
//    first.iterator().forEach {
//        println(it)
//    }
//
//    println()
//
//    nest.iterator().forEach {
//        it.iterator().forEach {
//                char ->
//            print(char)
//        }
//        println()
//
//    }

//
//    for (i in 0 .. 8) {
//        if(i<2){
//            continue
//        }
//
//        println(i)
//    }


//    var findWords = findWords(arrayOf("Hello"))
//    findWords.iterator().forEach {
//        it.iterator().forEach {
//            char ->
//            print(char) }
//    }


    var numberOfLines = numberOfLines(
        intArrayOf(
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10,
            10
        ), "bbbcccdddaaa"
    )


    numberOfLines.iterator().forEach {
        println(it)
    }

}

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {

    var hashSet = hashSetOf<Int>()
    var intArray = mutableListOf<Int>()


    for (i in 0 until nums1.size) {
        hashSet.add(i)
    }

    for (i in 0 until nums2.size) {
        if (hashSet.contains(nums2[i])) {
            if (intArray.contains(nums2[i]).not()) {
                intArray.add(nums2[i])
            }

        }
    }

    return intArray.toIntArray()

}


fun findWords(words: Array<String>): Array<String> {
    val strs = arrayOf("QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM")
    val results: MutableList<String> = ArrayList<String>()
    for (word in words) {
        var count1 = 0
        var count2 = 0
        var count3 = 0
        for (c in word.toCharArray()) {
            if (strs[0].lowercase().indexOf(c) != -1) count1++
            if (strs[1].lowercase().indexOf(c) != -1) count2++
            if (strs[2].lowercase().indexOf(c) != -1) count3++
        }
        if (count1 == 0 && count2 == 0 || count1 == 0 && count3 == 0 || count2 == 0 && count3 == 0) results.add(
            word
        )
    }
    return results.toTypedArray()
}


fun findWordss(words: Array<String>): Array<String>? {
    val strs = arrayOf("QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM")
    val map: MutableMap<Char, Int> = HashMap()
    for (i in strs.indices) {
        for (c in strs[i].toCharArray()) {
            map[c] = i //put <char, rowIndex> pair into the map
        }
    }
    val res: MutableList<String> = LinkedList()
    for (w in words) {
        if (w == "") continue
        var index = map[w.toUpperCase()[0]]!!
        for (c in w.toUpperCase().toCharArray()) {
            if (map[c] != index) {
                index = -1 //don't need a boolean flag.
                break
            }
        }
        if (index != -1) res.add(w) //if index != -1, this is a valid string
    }
    return res.toTypedArray()
}


fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
    var truckSize = truckSize
    val unitCount = IntArray(1001)
    for (boxType in boxTypes) {
        unitCount[boxType[1]] += boxType[0]
    }
    var count = 0
    for (i in unitCount.indices.reversed()) {
        if (unitCount[i] == 0) continue
        val num = Math.min(unitCount[i], truckSize)
        count += num * i
        truckSize -= num
        if (truckSize == 0) break
    }
    return count
}


fun maximumUnitss(boxTypes: Array<IntArray>, truckSize: Int): Int {
    var truckSize = truckSize
    Arrays.sort(
        boxTypes
    ) { x: IntArray, y: IntArray -> y[1] - x[1] }
    var count = 0
    val size = boxTypes.size
    var i = 0
    while (i < size && truckSize > 0) {
        val boxes = boxTypes[i][0]
        val units = boxTypes[i][1]
        truckSize -= boxes
        count += boxes * units
        if (truckSize < 0) {
            count += truckSize * units
            break
        }
        ++i
    }
    return count
}

//fun sumOfLeftLeaves(root: TreeNode?): Int {
//    if (root == null) return 0
//    var ans = 0
//    val stack: Stack<TreeNode> = Stack<TreeNode>()
//    stack.push(root)
//    while (!stack.empty()) {
//        val node: TreeNode = stack.pop()
//        if (node.left != null) {
//            if (node.left.left == null && node.left.right == null) ans += node.left.`val` else stack.push(
//                node.left
//            )
//        }
//        if (node.right != null) {
//            if (node.right.left != null || node.right.right != null) stack.push(node.right)
//        }
//    }
//    return ans
//}


//fun numberOfLines(widths: IntArray, s: String): IntArray {
//
//    var hashmap = mutableMapOf<Char, Int>()
//
//    println('a'-'a')
//
//
//    for (i in 'a'..'z') {
//        println(i)
//        println(widths[i-'a'])
//
//
//    }
//
//
//    var current = 0
//    current = hashmap.get(s.get(0))!!
//
//
//
//    return widths
//
//}


fun numberOfLines(widths: IntArray, s: String): IntArray {


    var hashmap = mutableMapOf<Char, Int>()


    for (i in 'a'..'z') {
        hashmap[i] = widths[i - 'a']
    }

    var currentLineLength = 0
    var current = 0
    var currentLines = 0

    var i =0
    while (i < s.length) {

        current = hashmap.get(s.get(i))!!

        if (currentLineLength + current > 100) {
            currentLineLength = 0
            currentLines++

        } else if (currentLineLength + current <= 100) {
            currentLineLength = currentLineLength + current
            i++
        }


    }

    val intArray = intArrayOf(currentLines + 1, currentLineLength)

    return intArray

}