package com.example.currencyconverter

sealed class Status {
    object Success: Status()
    object Error: Status()
    object Loading: Status()
}