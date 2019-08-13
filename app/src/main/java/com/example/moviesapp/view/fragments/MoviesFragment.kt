package com.example.moviesapp.view.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.moviesapp.MyApplication

import com.example.moviesapp.R
import com.example.moviesapp.responses.Movie
import com.example.moviesapp.viewcontroller.MoviesViewController

class MoviesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)

        if (MyApplication.activity != null) {
            val movies: MutableList<Movie> = mutableListOf()
            MoviesViewController.getMoviesList(view, movies)
        }

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        private var INSTANCE: MoviesFragment? = null

        fun getInstance(): MoviesFragment {
            if (INSTANCE == null)
                INSTANCE = MoviesFragment()
            return INSTANCE!!
        }
    }
}