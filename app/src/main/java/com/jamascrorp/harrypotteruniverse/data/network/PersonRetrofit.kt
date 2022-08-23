package com.jamascrorp.harrypotteruniverse.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PersonRetrofit {

    @GET("{id}")
    fun getPerson(@Path("id") string: String): Call<List<Person>>
}