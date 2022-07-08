package com.onuremren.movieexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onuremren.movieexample.repo.Repository

class MyViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return com.onuremren.movieexample.viewmodel.ViewModel(repository) as T
    }
}