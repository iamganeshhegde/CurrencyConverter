package com.example.currencyconverter.joke

import retrofit2.http.GET
import retrofit2.http.Path
import io.reactivex.Observable;


interface APIService {

    companion object {
        var BASE_URL: String
            get() = "https://api.chucknorris.io/jokes/"
            set(value) {

            }


        var base_new: String
            get() = "https://5e510330f2c0d300147c034c.mockapi.io/"
            set(value) {

            }

    }

    @GET("{path}")
    fun getRandomJoke(@Path("path") path: String?): Observable<Jokes>


    @GET("/users/1")
    fun getUser():Observable<NewUser>
}