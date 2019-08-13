package com.example.moviesapp.rest

import com.example.moviesapp.responses.Details
import com.example.moviesapp.responses.Movie
import com.example.moviesapp.responses.Images
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestInterface {

    @GET("/movies/popular")
    fun getMovies(@Query("limit") limit: String): Observable<List<Movie>>

    @GET("/movies/{id}")
    fun getMovieDetails(@Path("id") id: Int, @Query("extended") type: String): Observable<Details>

    @GET("movie/{id}")
    fun getMovieImages(@Path("id") id: Int, @Query("api_key") apiKey: String): Observable<Images>
}