package com.example.helloandroidmvvm.retrofit

import com.example.helloandroidmvvm.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface INewsApi {
    @GET("top-headlines")
    fun getNewsList(
        @Query("sources") newsSource: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>
}