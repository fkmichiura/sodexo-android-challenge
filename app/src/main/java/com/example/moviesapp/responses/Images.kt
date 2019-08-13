package com.example.moviesapp.responses

import com.google.gson.annotations.SerializedName

class Images(
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backdropPath: String
)