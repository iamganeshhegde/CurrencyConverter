package com.example.currencyconverter.miscellaneous.newactivities


import okhttp3.internal.notify
import okhttp3.internal.wait
import java.lang.Exception

class ThreadClass {
}
fun main() {

    var customer = Customer()

    Thread(){
        customer.withdraw(15000)
    }.start()

    Thread(){
        customer.deposit(1000)
    }.start()

}

class Customer {
    var amount = 10000

    @Synchronized
    fun withdraw(amountToWithDraw:Int) {
        println("Going to withdraw")
        if(amountToWithDraw > amount) {
            println("amount is less waiting to withdraw")
            try {
                wait()
            }catch (e:Exception) {

            }
        }
         println("Withdrwan money $amountToWithDraw")
        this.amount -= amountToWithDraw
        println("Current balance $amount")


    }






    @Synchronized
    fun deposit(amountToDeposit:Int) {
        println("Going to Deposit")
        this.amount += amountToDeposit
        println("Deposit complete")
        notify()

    }



}