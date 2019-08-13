package com.example.moviesapp.responses

import com.google.gson.annotations.SerializedName

//Movie details
class Details(
    @SerializedName("title") val title: String,
    @SerializedName("year") val year: Int,
    @SerializedName("overview") val overview: String,
    @SerializedName("released") val released: String,
    @SerializedName("trailer") val trailer: String,
    @SerializedName("homepage") val homepage: String,
    @SerializedName("ids") val ids: Ids
)