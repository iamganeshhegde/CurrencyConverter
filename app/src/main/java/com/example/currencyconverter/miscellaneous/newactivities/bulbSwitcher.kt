package com.example.currencyconverter.miscellaneous.newactivities


class bulbSwitcher {
}

fun main() {
    println(switch("001011101"))
}

fun switch(target:String): Int {
    var prev = '0'
    var res = 0

    for (c in target.toCharArray()) {
        if(c != prev) {
            prev = c
            res++
        }
    }

    return res
}

class Codec {
    var urls: MutableList<String> = ArrayList()

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        urls.add(longUrl)
        return (urls.size - 1).toString()
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String?): String {
        val index = Integer.valueOf(shortUrl)
        return if (index < urls.size) urls[index] else ""
    }
}