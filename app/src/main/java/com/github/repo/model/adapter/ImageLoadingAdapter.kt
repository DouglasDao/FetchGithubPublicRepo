package com.github.repo.model.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.repo.R
import com.github.repo.databinding.InflatePopulateImgBinding
import com.github.repo.model.adapter.listener.BaseRecyclerAdapterListener
import com.github.repo.model.adapter.viewholder.ImageLoadingViewHolder

class ImageLoadingAdapter(data: MutableList<Int>, private val listener: BaseRecyclerAdapterListener<Int>) : BaseRecyclerAdapter<Int, InflatePopulateImgBinding, ImageLoadingViewHolder>(data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageLoadingViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.inflate_populate_img, parent, false) as InflatePopulateImgBinding
        return ImageLoadingViewHolder(binding, listener)
    }
}
