package com.onuremren.movieexample.service

import android.telecom.Call
import com.onuremren.movieexample.model.MovieModelItem
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("movielist.json")
    suspend fun getAllMovies(): Response<List<MovieModelItem>>
}