package com.example.helloandroidmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.helloandroidmvvm.BuildConfig
import com.example.helloandroidmvvm.model.NewsResponse
import com.example.helloandroidmvvm.repository.NewsRepository

class NewsViewModel : ViewModel() {
    private var _mutableLiveData: MutableLiveData<NewsResponse>? = null
    private var newsRepository: NewsRepository? = null

    val mutableLiveData: LiveData<NewsResponse>?
        get() = _mutableLiveData

    init {
        newsRepository = NewsRepository.getInstance()

        // BuildConfig 클래스 사용하려면 최소 한 번 빌드 해야 함.
        _mutableLiveData = newsRepository?.getNews("google-news", BuildConfig.NEWS_API_KEY);
    }
}