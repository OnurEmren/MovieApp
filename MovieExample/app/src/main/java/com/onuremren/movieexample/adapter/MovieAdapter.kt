package com.onuremren.movieexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onuremren.movieexample.R
import com.onuremren.movieexample.databinding.ItemMovieBinding
import com.onuremren.movieexample.model.MovieModelItem


class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var movies = mutableListOf<MovieModelItem>()

    class MovieViewHolder(var view: ItemMovieBinding): RecyclerView.ViewHolder(view.root){

    }
    fun setMovieList(movies: List<MovieModelItem>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemMovieBinding>(inflater,
            R.layout.item_movie,parent,false)
        return MovieViewHolder(view)

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = movies[position]
        holder.view.movies = movies[position]
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.view.imageview)


    }

    override fun getItemCount(): Int {
        return movies.size
    }

}