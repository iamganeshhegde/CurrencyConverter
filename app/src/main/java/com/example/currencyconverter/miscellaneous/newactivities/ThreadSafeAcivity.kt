package com.example.currencyconverter.miscellaneous.newactivities

open class ThreadSafeAcivity(){

}


//thread safe and lazy

//class Singleton: ThreadSafeAcivity() {
//    private val LOCK = Any()
//    private var sInstance: Singleton? = null
//    val instance: Singleton?
//        get() {
//            if (sInstance == null) {
//                synchronized(LOCK) { sInstance = Singleton() }
//            }
//            return sInstance
//        }
//}


// thread safe lazy, but on static fields
//open class Singleton {
//
//    companion object {
//        var sInstance: Singleton? = null
//
//        @Synchronized
//        fun getInstance(): Singleton? {
//
//            if (sInstance == null) {
//                sInstance = Singleton()
//            }
//            return sInstance
//        }
//    }
//}


//Using volatile thread safe and lazy
class Singleton {
    @Volatile
    private var sInstance: Singleton? = null
    val instance: Singleton?
        get() {
            if (sInstance == null) {
                synchronized(Singleton::class.java) {
                    if (sInstance == null) {
                        sInstance = Singleton()
                    }
                }
            }
            return sInstance
        }
}