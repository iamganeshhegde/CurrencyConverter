package com.example.currencyconverter.miscellaneous.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {

    private var ourInstance: Retrofit? = null

    public fun getInstance(): Retrofit? {
        if (ourInstance == null) ourInstance = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return ourInstance
    }
}