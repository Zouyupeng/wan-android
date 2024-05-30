package com.oceanknight.wanandroid.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oceanknight.wanandroid.net.model.HomeBanner
import com.youth.banner.adapter.BannerAdapter

/**
 * @author  Oceanknight
 * @date    2024/5/30 22:46
 * --------------------------------------
 * @description
 *  首页banner用适配器
 */
class HomeBannerAdapter(data: MutableList<HomeBanner>? = null) : BannerAdapter<HomeBanner, HomeBannerAdapter.BannerViewHolder>(data){

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val img = ImageView(parent.context)
        img.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        img.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerViewHolder(img)
    }

    override fun onBindView(
        holder: BannerViewHolder,
        data: HomeBanner,
        position: Int,
        size: Int
    ) {
        val imgView = holder.itemView as ImageView
        Glide.with(imgView)
            .load(data.imagePath)
            .into(imgView)
    }
}