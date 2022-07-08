package com.onuremren.movieexample.service

import com.onuremren.movieexample.model.MovieModelItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieInterface {
    @GET("movielist.json")
    fun getMovie(): Call<List<MovieModelItem>>

    companion object{
        var retrofitService: MovieService?= null
        fun getInstance(): MovieService {
            if (retrofitService ==null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                retrofitService = retrofit.create(MovieService::class.java)
            }
            return retrofitService!!
        }

    }

}