package com.onuremren.movieexample.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.onuremren.movieexample.R
import com.onuremren.movieexample.adapter.MovieAdapter
import com.onuremren.movieexample.databinding.ActivityMainBinding
import com.onuremren.movieexample.databinding.FragmentListBinding
import com.onuremren.movieexample.repo.Repository
import com.onuremren.movieexample.service.MovieInterface
import com.onuremren.movieexample.viewmodel.MyViewModelFactory
import com.onuremren.movieexample.viewmodel.ViewModel


class ListFragment : Fragment() {
    private val retrofitService = MovieInterface.getInstance()
    lateinit var viewModel: ViewModel
    private lateinit var dataBinding: FragmentListBinding
    val adapter = MovieAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_list,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel = ViewModelProvider(this, MyViewModelFactory(Repository(retrofitService))).get(
            ViewModel::class.java)
        dataBinding.recyclerview.adapter = adapter

        viewModel.movieList.observe(viewLifecycleOwner) {
            adapter.setMovieList(it)
        }
        viewModel.loading.observe(viewLifecycleOwner){
            if (it){
                dataBinding.progressDialog.visibility = View.VISIBLE

            }else{
                dataBinding.progressDialog.visibility = View.INVISIBLE
            }
        }

        viewModel.getAllMovies()
    }
}