package com.example.appnutriologia.datasources

import com.example.appnutriologia.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL =  BuildConfig.BASE_URL_API

    private val gson: Gson = GsonBuilder().setLenient().create()

    private val client: OkHttpClient = OkHttpClient.Builder().build()

    val api:FoodApiService by lazy {
        Retrofit.Builder().
                baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(FoodApiService::class.java)
    }

}