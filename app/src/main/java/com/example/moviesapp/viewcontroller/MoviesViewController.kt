package com.example.moviesapp.viewcontroller

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.MyApplication
import com.example.moviesapp.R
import com.example.moviesapp.adapters.MoviesAdapter
import com.example.moviesapp.rest.Rest
import com.example.moviesapp.responses.Movie

object MoviesViewController {

    private lateinit var recyclerView: RecyclerView
    private val activity = MyApplication.activity

    fun getMoviesList(view: View, movies: MutableList<Movie>) {

        //Call trakt rest API getting movies list
        Rest.getMovies {

            //Response is successful
            if (it is List<*>) {

                for (mov in it) {

                    if (mov is Movie) {

                        //Add response objects to the list
                        movies.add(mov)
                    }
                }

                configList(view, movies)
                return@getMovies
            }

            //Response failed
            Toast.makeText(
                activity,
                "Ocorreu um problema. Por favor, tente novamente",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun configList(view: View, movies: MutableList<Movie>) {

        if (activity != null) {
            recyclerView = view.findViewById(R.id.movies_list) as RecyclerView
            val layoutManager = LinearLayoutManager(activity)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = MoviesAdapter(movies, activity)
        }
    }
}