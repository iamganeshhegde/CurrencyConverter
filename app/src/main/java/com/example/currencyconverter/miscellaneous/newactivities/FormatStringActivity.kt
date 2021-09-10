package com.example.currencyconverter.miscellaneous.newactivities

class FormatStringActivity {
}

fun main() {

}

fun interpret(command: String): String {

    var string = ""
    var isAL = false
    var isO = false

    for(i in 0 until command.length) {


        if(command.get(i) == 'G') {
            string = string+"G"
        }else if(command.get(i) == '(') {
            isO = true
            isAL = false

        }else if(command.get(i) == 'a' && isO == true) {
            isAL = true

            isO= false

        }else if(command.get(i)=='l') {
            isAL = true

        } else if(command.get(i) == ')' && isAL == false) {

            string = string+"o"

        } else if(command.get(i)==')' && isAL == true) {
            string = string+"al"
        }


    }


    return string


}