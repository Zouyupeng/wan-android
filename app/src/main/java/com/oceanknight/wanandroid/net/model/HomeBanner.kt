package com.oceanknight.wanandroid.net.model

import kotlinx.serialization.Serializable

/**
 * @author  Oceanknight
 * @date    2024/5/30 22:10
 * --------------------------------------
 * @description
 */
@Serializable
data class HomeBanner(
    var desc: String = "",
    var id: Int? = null,
    var imagePath: String = "",
    var isVisible: Int? = 0,
    var order: Int = 0,
    var title: String = "",
    var type: Int = 0,
    var url: String = ""
)