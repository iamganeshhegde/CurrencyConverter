package com.example.currencyconverter.miscellaneous

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

//fun SharedPreferences.string(
//    defaultValue: String = "",
//    key: (KProperty<*>) -> String = KProperty<*>::name
//): ReadWriteProperty<Any, String> =
//    object : ReadWriteProperty<Any, String> {
//        override fun getValue(
//            thisRef: Any,
//            property: KProperty<*>
//        ) = getString(key(property), defaultValue)
//        override fun setValue(
//            thisRef: Any,
//            property: KProperty<*>,
//            value: String
//        ) = edit().putString(key(property), value).apply()
//    }