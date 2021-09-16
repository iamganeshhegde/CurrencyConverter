package com.example.currencyconverter.miscellaneous.retrofit

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

var BASE_URL:String = "https://api.cryptonator.com/api/full/"

interface CryptocurrencyService {

    @GET("{coin}-usd")
    fun getCoinData(@Path("coin") coin: String?): Observable<MutableList<Crypto?>>?
}