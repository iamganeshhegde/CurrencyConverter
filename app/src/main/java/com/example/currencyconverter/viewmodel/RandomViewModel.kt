package com.example.currencyconverter.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomViewModel: ViewModel() {

    val status :MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}