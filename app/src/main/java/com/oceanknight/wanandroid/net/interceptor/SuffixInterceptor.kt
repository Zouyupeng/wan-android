package com.oceanknight.wanandroid.net.interceptor

import com.oceanknight.wanandroid.constants.Api
import okhttp3.Interceptor
import okhttp3.Response

/**
 *
 * author: Oceanknight
 * date: 2024/05/30
 * describe:
 * 添加后缀拦截器
 */
class SuffixInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val urlWithSuffix = request.url
            .newBuilder()
            .addPathSegment(Api.SUFFIX)
            .build()

        return chain.proceed(request.newBuilder().url(urlWithSuffix).build())
    }
}