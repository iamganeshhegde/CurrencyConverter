package com.example.currencyconverter.miscellaneous.retrofit

import io.reactivex.Observable
import retrofit2.http.GET




interface MyApi {
    @GET("posts")
    fun getPosts(): Observable<List<Posts>>
}