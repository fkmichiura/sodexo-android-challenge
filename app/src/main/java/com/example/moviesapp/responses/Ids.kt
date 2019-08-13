package com.example.moviesapp.responses

import com.google.gson.annotations.SerializedName

class Ids(
    @SerializedName("trakt") val trakt: Int,
    @SerializedName("tmdb") val tmdb: Int
)
