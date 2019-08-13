package com.example.moviesapp.rest

import com.example.moviesapp.utils.Constants.Companion.API_VERSION
import com.example.moviesapp.utils.Constants.Companion.TRAKT_BASE_URL
import com.example.moviesapp.utils.Constants.Companion.CLIENT_ID
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal object TraktApi {

    fun initRest(): Retrofit {
        //Interceptor
        val interceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-type", "application/json")
                .addHeader("trakt-api-key", CLIENT_ID)
                .addHeader("trakt-api-version", API_VERSION)
                .build()
            chain.proceed(request)
        }

        //OkHttpClient
        val client = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)

        return Retrofit.Builder()
            .baseUrl(TRAKT_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client.build())
            .build()
    }
}