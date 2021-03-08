package com.newsapp.remo_impl.remote.base

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitCreator(
    private val baseUrl: String
) {

    private val client: OkHttpClient
        get() = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).build()

    private val gson: Gson
        get() = GsonBuilder().create()


    fun build(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }
}