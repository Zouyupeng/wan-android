package com.oceanknight.wanandroid.utils.databinding

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.oceanknight.wanandroid.base.App
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 *
 * author: Oceanknight
 * date: 2024/05/31
 * describe:
 */
object GlideDataBindingComponent {

    /**
     * 加载图片
     *
     * @param url       图片来源
     * @param holder    占位图
     * @param corner    圆角半径
     */
    @BindingAdapter(value = ["img", "holder", "corner"], requireAll = false)
    @JvmStatic
    fun loadImageWithHolder(v: ImageView, url: Any?, holder: Drawable?, corner: Int?) {
        if (url == null && holder == null) v.setImageDrawable(null)
        val requestBuilder = Glide.with(v.context).load(url).placeholder(holder)
        if (corner != null) {
            requestBuilder.transform(
                CenterCrop(),
                // dp * density = px
                RoundedCorners((corner * App.appContext().resources.displayMetrics.density).toInt())
            )
        }
        requestBuilder.into(v)
    }
}