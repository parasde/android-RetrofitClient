package com.prasde.retrofit.server

import io.reactivex.rxjava3.core.Flowable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    fun test (@Url url: String): Flowable<ResponseBody>
}