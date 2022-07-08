package com.onuremren.movieexample.repo

import com.onuremren.movieexample.service.MovieService

class Repository(private val retrofitService: MovieService) {
    suspend fun getAllMovies() = retrofitService.getAllMovies()
}