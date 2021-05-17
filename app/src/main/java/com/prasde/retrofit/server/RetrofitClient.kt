package com.prasde.retrofit.server

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL = "https://www.google.com"
    private val instance: Retrofit by lazy {
        val okBuilder = OkHttpClient.Builder()
        okBuilder.interceptors().add(InterceptorReqHeader())
        okBuilder.interceptors().add(InterceptorResHeader())
        okBuilder.connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
        val client = okBuilder.build()

        val retrofitBuilder = Retrofit.Builder()
        return@lazy retrofitBuilder.client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        instance.create(ApiService::class.java)
    }
}
