package com.example.moviesapp.responses

import com.google.gson.annotations.SerializedName

//Movies
class Movie(
    @SerializedName("title") val title: String,
    @SerializedName("year") val year: Int,
    @SerializedName("ids") val ids: Ids
)