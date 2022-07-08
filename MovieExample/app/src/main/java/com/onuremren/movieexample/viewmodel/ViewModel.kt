package com.onuremren.movieexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onuremren.movieexample.repo.Repository
import com.onuremren.movieexample.model.MovieModelItem
import kotlinx.coroutines.*


class ViewModel(private val repository: Repository): ViewModel() {
    val movieList = MutableLiveData<List<MovieModelItem>>()
    val loading = MutableLiveData<Boolean>()
    var job: Job? = null

    fun getAllMovies(){
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getAllMovies()
            loading.postValue(true)
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    movieList.postValue(response.body())
                    loading.postValue(false)

                }else{
                    println("HATA!")
                }
            }
        }
    }
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}