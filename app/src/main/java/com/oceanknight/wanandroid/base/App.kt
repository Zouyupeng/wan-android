package com.oceanknight.wanandroid.base

import android.app.Application
import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.drake.net.NetConfig
import com.drake.net.okhttp.setConverter
import com.drake.net.okhttp.setDebug
import com.oceanknight.wanandroid.BuildConfig
import com.oceanknight.wanandroid.constants.Api
import com.oceanknight.wanandroid.net.convert.SerializationConverter
import com.oceanknight.wanandroid.net.interceptor.SuffixInterceptor
import dagger.hilt.android.HiltAndroidApp
import okhttp3.Cache
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class App: Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: App? = null

        /**
         * 获取app Context
         * 虽然有hilt, 但是一些object内还是需要用这种方法来获得App的Context
         *
         * @return
         */
        fun appContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        // 初始化网络通信
        NetConfig.initialize(Api.HOST, this) {
            // 超时设置
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)

            // 本框架支持Http缓存协议和强制缓存模式
            // 缓存设置, 当超过maxSize最大值会根据最近最少使用算法清除缓存来限制缓存大小
            cache(Cache(cacheDir, 1024 * 1024 * 128))

            // LogCat是否输出异常日志, 异常日志可以快速定位网络请求错误
            setDebug(BuildConfig.DEBUG)

            // 仅开发模式启用通知栏监听网络日志, 该框架存在下载大文件时内存溢出崩溃请等待官方修复 https://github.com/ChuckerTeam/chucker/issues/1068
            if (BuildConfig.DEBUG) {
                addInterceptor(
                    ChuckerInterceptor.Builder(this@App)
                        .collector(ChuckerCollector(this@App))
                        .maxContentLength(250000L)
                        .redactHeaders(emptySet())
                        .alwaysReadResponseBody(false)
                        .build()
                )
            }

            // 添加 wan android 系列接口的 "/json" 后缀
            addInterceptor(SuffixInterceptor())

            // 数据转换器
            setConverter(SerializationConverter())
        }
    }
}