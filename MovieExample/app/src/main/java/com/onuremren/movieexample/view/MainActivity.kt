package com.onuremren.movieexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.onuremren.movieexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)



    }



}