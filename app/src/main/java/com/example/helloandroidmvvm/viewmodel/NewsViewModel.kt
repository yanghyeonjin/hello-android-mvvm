package com.example.helloandroidmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.helloandroidmvvm.model.NewsResponse
import com.example.helloandroidmvvm.repository.NewsRepository

class NewsViewModel : ViewModel() {
    private var _mutableLiveData: MutableLiveData<NewsResponse>? = null
    private var newsRepository: NewsRepository? = null

    val mutableLiveData: LiveData<NewsResponse>?
        get() = _mutableLiveData

    init {
        newsRepository = NewsRepository.getInstance()
        _mutableLiveData = newsRepository?.getNews("google-news", "API_KEY");
    }
}