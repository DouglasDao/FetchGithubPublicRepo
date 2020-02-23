package com.github.repo.model.adapter.viewholder

import android.view.View
import androidx.databinding.BindingAdapter
import com.android.volley.toolbox.NetworkImageView
import com.github.repo.GithubRepoApplication
import com.github.repo.databinding.InflateFetchRepoBinding
import com.github.repo.model.adapter.listener.BaseRecyclerAdapterListener
import com.github.repo.model.response.GitFetchResponse

class GithubRepoViewHolder(binding: InflateFetchRepoBinding, private val listener: BaseRecyclerAdapterListener<GitFetchResponse>) : BaseViewHolder<GitFetchResponse, InflateFetchRepoBinding>(binding.root, binding), View.OnClickListener {

    override fun populateData() {
        binding.repo = data
        binding.repoOwner = data.owner
        binding.executePendingBindings()
        itemView.setOnClickListener(this)
    }

    override fun onClick(itemView: View?) {
        listener.onClickItem(data, adapterPosition)
    }
}