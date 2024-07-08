package com.oceanknight.wanandroid.constants

object Api {
    const val HOST = "https://www.wanandroid.com"
    const val SUFFIX = "json"

    // 首页banner 1.2
    const val BANNER = "/banner"
    // 首页文章列表 1.1
    // 后加页码，页码从0开始
    const val HOME_ARTICLE = "/article/list/"
    // 置顶文章 1.5
    const val TOP_ARTICLE = "/article/top"
    // 广场列表数据 10.1
    const val USER_ARTICLE = "/user_article/list/"
}