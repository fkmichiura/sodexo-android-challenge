package com.example.moviesapp.view.fragments.manager

import androidx.fragment.app.FragmentTransaction
import com.example.moviesapp.MyApplication
import com.example.moviesapp.R
import com.example.moviesapp.view.fragments.DetailsFragment
import com.example.moviesapp.view.fragments.MoviesFragment

object FragmentManager {

    private val activity = MyApplication.activity

    fun callMoviesFragment() {
        if (activity != null) {
            val fragment = MoviesFragment.getInstance()
            activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .addToBackStack("Movies")
                .commit()
        }
    }

    fun callDetailsFragment() {
        if (activity != null) {
            val fragment = DetailsFragment.getInstance()
            activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .addToBackStack("Details")
                .commit()
        }
    }
}