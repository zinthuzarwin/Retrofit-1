package com.example.retrofitassignment.api

import com.example.retrofitassignment.model.Typicode
import retrofit2.Call
import retrofit2.http.GET

interface TypicodeApiInterface  {
    @GET("posts")
    fun getPost(): Call<List<Typicode>>
}