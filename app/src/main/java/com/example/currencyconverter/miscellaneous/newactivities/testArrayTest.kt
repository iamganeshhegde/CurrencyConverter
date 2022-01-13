package com.example.currencyconverter.miscellaneous.newactivities

object HelloWorld {
    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello World")
        val arr = intArrayOf(80, 2, 6, 3, 100)
        val size = arr.size
        println(maxDiff(arr, size))
    }

    fun maxDiff(arr: IntArray, n: Int): Int {
        // Create a diff array of size n-1. The array will hold
        //  the difference of adjacent elements
        val diff = IntArray(n - 1)
        for (i in 0 until n - 1) diff[i] = arr[i + 1] - arr[i]
        for (i in 0 until diff.size) println(diff[i])
        // diff = { -78, 4 ,-3, 97 }

        // Now find the maximum sum subarray in diff array
        var max_diff = diff[0] // -78,
        for (i in 1 until n - 1) {
            if (diff[i - 1] > 0) diff[i] += diff[i - 1] //-78,-74,
                println("$i -> diff[$i], ${diff[i]}") //{ 78, 82, 7, 100 }
            if (max_diff < diff[i]) max_diff = diff[i]
                println("$i -> diff[$i], maxdiff -> $max_diff")
        }
        return max_diff
    } // Driver program to test above functions
    // public static void main(String[] args)
    // {
    //     MaximumDiffrence mxdif = new MaximumDiffrence();
    //     int arr[] = {80, 2, 6, 3, 100};
    //     int size = arr.length;
    //     System.out.println(mxdif.maxDiff(arr, size));
    // }
}