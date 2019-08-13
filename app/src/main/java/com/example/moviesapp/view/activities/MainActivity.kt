package com.example.moviesapp.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp.MyApplication
import com.example.moviesapp.R
import com.example.moviesapp.view.fragments.manager.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get MainActivity instance
        MyApplication.activity = this

        FragmentManager.callMoviesFragment()
    }
}