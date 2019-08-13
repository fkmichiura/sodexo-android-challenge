package com.example.moviesapp.rest

import android.annotation.SuppressLint
import com.example.moviesapp.utils.Constants.Companion.API_KEY
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

object Rest {
    private var traktRetrofit: Retrofit? = null
    private var tmdbRetrofit: Retrofit? = null

    private val traktRest: RestInterface
        get() {
            if (traktRetrofit == null) {
                traktRetrofit = TraktApi.initRest()
            }

            return traktRetrofit!!.create(RestInterface::class.java)
        }

    private val tmdbRest: RestInterface
        get() {
            if (tmdbRetrofit == null) {
                tmdbRetrofit = TmdbApi.initRest()
            }

            return tmdbRetrofit!!.create(RestInterface::class.java)
        }

    @SuppressLint("CheckResult")
    private fun connect(observable: Observable<*>, handler: (it: Any?) -> Unit) {
        observable
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                handler(it)
            }, {
                handler(it)
            })
    }

    //Rest calls
    fun getMovies(handler: (it: Any?) -> Unit) {
        connect(traktRest.getMovies("99"), handler)
    }

    fun getDetails(id: Int, handler: (it: Any?) -> Unit) {
        connect(traktRest.getMovieDetails(id, "full"), handler)
    }

    fun getImages(id: Int, handler: (it: Any?) -> Unit) {
        connect(tmdbRest.getMovieImages(id, API_KEY), handler)
    }
}