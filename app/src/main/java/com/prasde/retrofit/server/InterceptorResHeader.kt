package com.prasde.retrofit.server

import okhttp3.Interceptor
import okhttp3.Response

class InterceptorResHeader: Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val response: Response = chain.proceed(chain.request())
        val header: String? = response.header("name")
        return response
    }
}