package com.github.repo.model.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.repo.BR
import com.github.repo.R
import com.github.repo.databinding.InflateFetchRepoBinding
import com.github.repo.model.adapter.listener.BaseRecyclerAdapterListener
import com.github.repo.model.adapter.viewholder.GithubRepoViewHolder
import com.github.repo.model.response.GitFetchResponse

class GithubRepoAdapter(data: MutableList<GitFetchResponse>, private val listener: BaseRecyclerAdapterListener<GitFetchResponse>) : BaseRecyclerAdapter<GitFetchResponse, InflateFetchRepoBinding, GithubRepoViewHolder>(data) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.inflate_fetch_repo, parent, false) as InflateFetchRepoBinding
        return GithubRepoViewHolder(binding, listener)
    }
}
