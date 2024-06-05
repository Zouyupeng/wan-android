package com.oceanknight.wanandroid.net.model
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


/**
 *
 * author: zouyupeng
 * date: 2024/06/05
 * describe:
 * 删除了一些字段不做解析
 */
@Serializable
data class Article(
    @SerialName("curPage")
    var curPage: Int = 0,
    @SerialName("datas")
    var data: List<Data> = listOf(),

    /** 是否还有后续 */
    @SerialName("over")
    var over: Boolean = false,

    /** 最大页数 */
    @SerialName("pageCount")
    var pageCount: Int = 0,
) {
    @Serializable
    data class Data(
        @SerialName("author")
        var author: String = "",

        /** 分享者 如果此字段size != 0 则 author字段size == 0 */
        @SerialName("shareUser")
        var shareUser: String = "",

        /** 二级分类id */
        @SerialName("chapterId")
        var chapterId: Int = 0,
        @SerialName("chapterName")
        var chapterName: String = "",

        /** 一级分类id, 但这里实际是一级分类的第一个子类目id */
        @SerialName("superChapterId")
        var superChapterId: Int = 0,
        @SerialName("superChapterName")
        var superChapterName: String = "",

        /** 真正的一级分类id */
        @SerialName("realSuperChapterId")
        var realSuperChapterId: Int = 0,

        @SerialName("id")
        var id: Int = 0,

        @SerialName("link")
        var link: String = "",

        /** 时间, 似乎没有用到niceShareDate这个字段的场景 */
        @SerialName("niceDate")
        var niceDate: String = "",
        @SerialName("publishTime")
        var publishTime: Long = 0,

        /** 项目代码仓库地址 */
        @SerialName("projectLink")
        var projectLink: String = "",

        /** 似乎有公众号,本站发布,问答 */
        @SerialName("tags")
        var tags: List<Tag> = listOf(),

        @SerialName("title")
        var title: String = "",

        @SerialName("userId")
        var userId: Int = 0,

    ) {
        @Serializable
        data class Tag(
            @SerialName("name")
            var name: String = "",
            @SerialName("url")
            var url: String = ""
        )
    }
}