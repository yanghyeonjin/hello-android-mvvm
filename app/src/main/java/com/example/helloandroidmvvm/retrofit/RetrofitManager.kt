package com.example.helloandroidmvvm.retrofit

class RetrofitManager {
    companion object {
        val instance = RetrofitManager()
    }

    // 인터페이스 가져오기
    val iNewsApi: INewsApi? = RetrofitClient.getClient(
        "https://newsapi.org/v2/"
    )?.create(INewsApi::class.java)
}