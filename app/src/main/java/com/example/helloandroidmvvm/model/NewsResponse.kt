package com.example.helloandroidmvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("status")
    @Expose
    var status: String,
    @SerializedName("totalResults")
    @Expose
    var totalResults: Int,
    @SerializedName("articles")
    @Expose
    var articles: List<NewsArticle>) {
}