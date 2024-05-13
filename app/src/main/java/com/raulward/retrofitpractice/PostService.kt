package com.raulward.retrofitpractice

import android.telecom.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun list(): retrofit2.Call<List<PostEntity>>
}