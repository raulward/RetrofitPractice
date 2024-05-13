package com.raulward.retrofitpractice

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient private constructor(){

    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private fun getRetrofitInstance() : Retrofit {
            if (!::INSTANCE.isInitialized) {
                val http = OkHttpClient.Builder()
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
            return INSTANCE
        }

        fun <S> createService(serviceClass: Class<S>): S {
            return getRetrofitInstance().create(serviceClass)
        }

    }
}