package com.prasde.retrofit.server

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class InterceptorReqHeader: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder().addHeader("name", "value")
        return chain.proceed(builder.build())
    }
}