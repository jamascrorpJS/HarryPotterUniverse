package com.jamascrorp.harrypotteruniverse.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object Retrofit {

    private val baseUrl by lazy { if (Locale.getDefault().language == "en") "http://hp-api.herokuapp.com/api/" else "https://62ff213341165d66bfc9c3f9.mockapi.io/" }

    private val client = OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl(baseUrl)
        .build()

    val personRetrofit: PersonRetrofit by lazy {
        retrofit.create(PersonRetrofit::class.java)
    }
}