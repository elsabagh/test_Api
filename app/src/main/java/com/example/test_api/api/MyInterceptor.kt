package com.example.test_api.api

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("content_type","application/json")
            .addHeader("x-Platform","Android")
            .addHeader("x-Auth-Token","123456789")
            .build()
        return chain.proceed(request)
    }
}