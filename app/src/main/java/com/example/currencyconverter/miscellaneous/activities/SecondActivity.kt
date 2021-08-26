package com.example.currencyconverter.miscellaneous.activities

import com.example.currencyconverter.miscellaneous.newactivities.ThirdActivity
import java.math.BigInteger
import java.util.*
import kotlin.collections.ArrayList


internal class SecondActivity {

    var abc = ThirdActivity()


    fun a() {

    }
}

//fun trailingZeroes(n: Int): Int {
//    val n = n
//    var count = 0
//    while (n != 0) {
//        val tmp = n / 5
//        count += tmp
//        n = tmp
//    }
//    return count

//
//}

fun main() {


//    search(0,5,kotlin.intArrayOf(1,2,4,5,6),3)


//    kotlin.io.println(searchInsert(kotlin.intArrayOf(1,3,5,7), 6))

//    println(isValid("()"))

//    plusOne(intArrayOf(9))
//    var a ="5"
//    var aa = BigInteger("5")
//    var bb = BigInteger("3")
//
//    println(addBinary(aa.toString(), bb.toString()))
//
//
//    val b1: BigInteger
//    b1 = BigInteger("321456")

    // create radix


//    println(b1.toString())

    // create radix
//    val radix = 2

    // apply toString(radix) method

    // apply toString(radix) method
//    val b1String = b1.toString(radix)

    // print String

    // print String
//    println(
//        "Binary String of BigInteger "
//                + b1 + " is equal to " + b1String
//    )



//    println(shuffle(intArrayOf(2,5,1,3,4,7),3).iterator().forEach { println(it) })

//    var result = 0
//    for (i in 0 until n) {
//        result = result xor  A.get(i)
//    }
//    return result



    //swap
//    com.example.currencyconverter.miscellaneous.activities.swap(1,2)


//    var a = "aaa"


//   println(
//       countNegatives(arrayOf(intArrayOf(4,3,2,-1), intArrayOf(3,2,1,-1), intArrayOf(1,1,-1,-2),
//       intArrayOf(-1,-1,-2,-3)))
//   )


//    kotlin.io.println(hammingWeight(521))

//    checkExtraChar()


    kotlin.io.println(convertToTitle(12))
}


fun countNegatives(grid: Array<IntArray>): Int {

    var count = 0

    for(i in 0 until grid.size) {


        for(j in 0 until grid[i].size-1) {
            if(grid[i][j] < 0) {
                count++
            }
        }

    }


    return count
}


fun hammingWeight(n:Int):Int {

    var sum = 0
    var number = n
    while (number != 0) {
        sum++
        number = number and (number - 1)
    }
    return sum
}


fun checkExtraChar() {
    var string = "abcd"
    var shuffle = "bdacf"
    var count1 = 0
    var count2 = 0

    for (i in 0 until string.length) {
         count1 += string[i] - 'a'
    }

    for(i in 0 until shuffle.length) {
        count2 += shuffle[i] - 'a'
    }
    var aa = (count2 - count1)

    var answer = aa + 97

    println(answer.toChar())




}


//fun findTheDifference(s: String, t: String): Char {
//    val sum_s = 'a'
//    var sum_t = 'a'
//    var i = 0
//    while (i < s.length) {
//        sum_s += s[i]
//        sum_t += t[i]
//        i++
//    }
//    sum_t += t[i]
//    return (sum_t - sum_s) as Char
//}



//fun titleToNumber(s: String): Int {
//    val result = 0
//    for (i in 0 until s.length) {
//        result = result * 26 + (s[i] - 'A' + 1)
//    }
//    return result
//}


fun swap( a:Int, b:Int) {
//    var aa = a
//    var bb = b
//    aa=aa+bb-(bb=aa)
//
//    println("a -$aa,  b- $bb")
}


fun convertToTitle(n: Int): String? {
    var nn = n
    var result = ""
    while (nn > 0) {
        nn--
        result = ('A'.toInt() + nn % 26).toChar().toString()+result
        nn = nn / 26
    }
    return result
}


fun search(start:Int, end:Int, nums: IntArray, target: Int) {

    if(start>end) {
        return
        println( start+1)
    }

    var answer = start

    var middle:Int = (start+end-1)/2

    var middleNumber = nums.get(middle)

    if(middleNumber == target) {
        println(middle)
    } else if(target < middleNumber) {
        search(start, middle,nums, target)

    } else if(target >= middleNumber){
        search(middle+1, end ,nums, target)
    }
}


fun searchInsert(nums: IntArray, target: Int): Int {


    var answer = 0
    var low =0
    var high = nums.size

    while(low < high) {

        var mid = (low+high-1)/2
        if(nums[mid] == target) {
            answer = mid
            return answer
        } else if(target < nums[mid]) {
            high = mid
            answer = high
        } else {
            low = mid+1
            answer = low
        }

    }
    return answer
}



fun shuffle(nums: IntArray, n: Int): IntArray {

    var array = IntArray(nums.size)

    var j=n
    var i=0
    var k=0


    while(i <= n &&  j < nums.size && k < nums.size) {
        if(k%2 == 0) {
            array[k] = nums[i]
            k++
            i++
        } else {
            array[k] = nums[j]
            k++
            j++
        }

    }

    return array

}

fun addBinary(a: String, b: String): String {

    return BigInteger(a).toString(2)
}

fun plusOne(digits: IntArray): IntArray {

    /*var totalValue:Double = 0.0

    for(i in 0 until digits.size) {


        totalValue = totalValue + ((Math.pow(10.toDouble(), (digits.size-1 - i).toDouble()))  * digits.get(i))

    }

    totalValue = totalValue+1




    val temp = Integer.toString(totalValue.toInt())
    var newArray = IntArray(temp.length)

    for (j in 0 until temp.length) {
        newArray[j] = temp[j] - '0'
        println(newArray[j])
    }

    return newArray*/

    for (i in digits.size - 1 downTo 0) {
        if (digits.get(i) !== 9) {
            digits[i]++
            break
        } else {
            digits[i] = 0
        }
    }
    if (digits.get(0) === 0) {
        val res = IntArray(digits.size + 1)
        res[0] = 1
        return res
    }
    return digits
}


fun isValid(s: String): Boolean {

    var arraylist = ArrayList<String>()

    var i = 0
    while(i < s.length) {

        when(s.get(i).toString()) {
            "(" -> {
                arraylist.add(s.get(i).toString())
            }
            "[" -> {
                arraylist.add(s.get(i).toString())

            }
            "{" -> {
                arraylist.add(s.get(i).toString())
            }
            ")" -> {
                if(arraylist != null && arraylist.size >0 && (arraylist.get(arraylist.size -1) == "(")) {
                    arraylist.removeAt(arraylist.size -1)
                } else {
                    return false
                }

            }
            "]" -> {
                if(arraylist != null && arraylist.size >0 && (arraylist.get(arraylist.size -1) == "[")) {
                    arraylist.removeAt(arraylist.size -1)

                }
                else {
                    return false
                }

            }
            "}" -> {
                if(arraylist != null && arraylist.size >0 && (arraylist.get(arraylist.size -1) == "{")) {
                    arraylist.removeAt(arraylist.size -1)
                }
                else {
                    return false
                }

            }

        }
        i++

    }

    if(arraylist.size == 0) {
        return true
    }

    return false


}


fun aaaa() {
    var a = intArrayOf(1,2,3,4)

//    var tree = TreeSet<Int>(a)
//
//    println(tree)

}