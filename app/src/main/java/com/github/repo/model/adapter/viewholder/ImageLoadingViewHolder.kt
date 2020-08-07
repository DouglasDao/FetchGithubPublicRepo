package com.github.repo.model.adapter.viewholder

import android.view.View
import com.github.repo.databinding.InflatePopulateImgBinding
import com.github.repo.model.adapter.listener.BaseRecyclerAdapterListener


class ImageLoadingViewHolder(
    binding: InflatePopulateImgBinding,
    private val listener: BaseRecyclerAdapterListener<Int>
) : BaseViewHolder<Int, InflatePopulateImgBinding>(binding.root, binding), View.OnClickListener {

    override fun populateData() {

        val res = mContext.resources.getDrawable(data, null)
        binding.ivAvatar.setImageDrawable(res)
        itemView.setOnClickListener(this)
    }

    override fun onClick(itemView: View?) {
        listener.onClickItem(data, adapterPosition)
    }
}