package com.example.moviesapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.responses.Movie
import com.example.moviesapp.utils.Preferences
import com.example.moviesapp.view.fragments.manager.FragmentManager
import kotlinx.android.synthetic.main.movie_cell.view.*

class MoviesAdapter(private val movies: List<Movie>, private val context: Context) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_cell, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]

        holder.bindView(movie)
        //Set click listener for movie cells
        holder.itemView.setOnClickListener {
            //Save movie ID to SharedPreferences
            val success = Preferences(context).set(movie.ids.trakt)

            //Call Details screen when SharedPreferences successful saved
            if (success) {
                FragmentManager.callDetailsFragment()
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(movie: Movie) {
            val title = itemView.movie_title
            val year = itemView.movie_year

            title.text = movie.title
            year.text = movie.year.toString()
        }
    }
}