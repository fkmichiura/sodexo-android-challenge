package com.example.moviesapp

import android.app.Application
import com.example.moviesapp.view.activities.MainActivity

class MyApplication : Application() {
    companion object {
        var activity: MainActivity? = null
    }
}