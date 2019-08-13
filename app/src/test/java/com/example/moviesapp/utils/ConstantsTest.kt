package com.example.moviesapp.utils

import com.example.moviesapp.utils.Constants.Companion.API_KEY
import com.example.moviesapp.utils.Constants.Companion.TRAKT_BASE_URL
import com.example.moviesapp.utils.Constants.Companion.CLIENT_ID
import com.example.moviesapp.utils.Constants.Companion.IMG_BASE_URL
import com.example.moviesapp.utils.Constants.Companion.TMDB_BASE_URL
import org.junit.Assert
import org.junit.Test

class ConstantsTest {

    @Test
    fun assertThatTraktBaseUrl_IsEqual() {
        val result = "https://api.trakt.tv"
        Assert.assertEquals(result, TRAKT_BASE_URL)
    }

    @Test
    fun assertThatClientId_IsEqual() {
        val result = "a6f384cad85bb0f09378d676d4ee50ef5c096caa944877d6fda398c4150e6ebb"
        Assert.assertEquals(result, CLIENT_ID)
    }

    @Test
    fun assertThatTmdbBaseUrl_IsEqual() {
        val result = "https://api.themoviedb.org/3/"
        Assert.assertEquals(result, TMDB_BASE_URL)
    }

    @Test
    fun assertThatImgBaseUrl_IsEqual() {
        val result = "https://image.tmdb.org/t/p/w500"
        Assert.assertEquals(result, IMG_BASE_URL)
    }

    @Test
    fun assertThatApiKey_IsEqual() {
        val result = "b3118c308b01261e78d093d711aa345f"
        Assert.assertEquals(result, API_KEY)
    }
}