package com.oceanknight.wanandroid.net.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author Oceanknight
 * @date 2024/07/08
 * 项目数据类
 */
@Serializable
data class ProjectModel(
    @SerialName("curPage")
    var curPage: Int = 0,
    @SerialName("datas")
    var projectList: List<Project> = listOf(),

    /** 是否还有后续 true-没有 */
    @SerialName("over")
    var over: Boolean = false,
    /** 最大页数 */
    @SerialName("pageCount")
    var pageCount: Int = 0,
) {
    @Serializable
    data class Project(
        /** 作者 */
        @SerialName("author")
        var author: String = "",
        /** 标题 */
        @SerialName("title")
        var title: String = "",
        /** 描述 */
        @SerialName("desc")
        var desc: String = "",

        /** 封面图链接 */
        @SerialName("envelopePic")
        var coverPictureUrl: String = "",

        /** App下载链接 可为空字符串 */
        @SerialName("apkLink")
        var apkLink: String = "",

        /** 二级分类id */
        @SerialName("chapterId")
        var chapterId: Int = 0,
        @SerialName("chapterName")
        var chapterName: String = "",

        @SerialName("id")
        var id: Int = 0,

        /** 本站文章链接 */
        @SerialName("link")
        var link: String = "",

        /** 时间 似乎和niceShareDate/publishTime/shareDate是一样的 */
        @SerialName("niceDate")
        var niceDate: String = "",

        /** 开源链接 */
        @SerialName("projectLink")
        var projectLink: String = "",

        /** 真正的一级分类id */
        @SerialName("realSuperChapterId")
        var realSuperChapterId: Int = 0,

        /** 看了几页 这个都是空 */
        @SerialName("shareUser")
        var shareUser: String = "",

        /** 一级分类id, 但这里实际是一级分类的第一个子类目id */
        @SerialName("superChapterId")
        var superChapterId: Int = 0,
        @SerialName("superChapterName")
        var superChapterName: String = "",

        /** 标签 有公众号,本站发布,问答,项目 url代表要访问的接口 */
        @SerialName("tags")
        var tags: List<Tag> = listOf(),

        /** 可视性 1-可视 */
        @SerialName("visible")
        var visible: Int = 0,
    ) {
        val simplifyTime
            get() = if (niceDate.length >= 10) niceDate.substring(0, 10)
            else niceDate

        @Serializable
        data class Tag(
            @SerialName("name")
            var name: String = "",
            @SerialName("url")
            var url: String = ""
        )
    }
}