package com.example.moviesapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviesapp.MyApplication

import com.example.moviesapp.R
import com.example.moviesapp.utils.Preferences
import com.example.moviesapp.viewcontroller.DetailsViewController

class DetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        if (MyApplication.activity != null) {
            val movieId = Preferences(MyApplication.activity!!).get()
            DetailsViewController.getMovieDetails(view, movieId)
        }

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        private var INSTANCE: DetailsFragment? = null

        fun getInstance(): DetailsFragment {
            if (INSTANCE == null)
                INSTANCE = DetailsFragment()
            return INSTANCE!!
        }
    }
}