package com.example.helloandroidmvvm.repository

import androidx.lifecycle.MutableLiveData
import com.example.helloandroidmvvm.model.NewsResponse
import com.example.helloandroidmvvm.retrofit.RetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    companion object {
        private var newsRepository: NewsRepository? = null

        fun getInstance(): NewsRepository? {
            if (newsRepository == null) {
                newsRepository = NewsRepository()
            }

            return newsRepository
        }
    }

    fun getNews(source: String, key: String): MutableLiveData<NewsResponse> {
        val newsData: MutableLiveData<NewsResponse> = MutableLiveData()

        // api 통신
        RetrofitManager.instance.iNewsApi?.getNewsList(newsSource = source, apiKey = key)?.
        enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                newsData.value = null
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    newsData.value = response.body()
                }
            }

        })

        return newsData
    }
}