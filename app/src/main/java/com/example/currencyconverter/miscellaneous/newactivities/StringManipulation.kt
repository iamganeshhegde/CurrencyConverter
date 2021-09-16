package com.example.currencyconverter.miscellaneous.newactivities

import java.util.*


class StringManipulation {


}

fun main() {
    var a = "abc def ghi"

    var list = a.split(" ").toMutableList()
    list[0].substring(1)
    list[0] = list[0]+"aa"

}


fun toGoatLatin(S: String): String? {
    val vowels: Set<Char> = HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'))
    var res = ""
    var i = 0
    var j = 0
    for (w in S.split("\\s").toTypedArray()) {
        res += ' '.toString() + (if (vowels.contains(w[0])) w else w.substring(1) + w[0]) + "ma"
        j = 0
        ++i
        while (j < i) {
            res += "a"
            ++j
        }
    }
    return res.substring(1)
}