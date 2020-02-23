package com.github.repo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.repo.R
import com.github.repo.databinding.FragmentGithubRepoDetailsBinding
import com.github.repo.model.response.GitFetchResponse
import com.github.repo.view.utils.Constants.RequestKey.REPO_DETAILS

class GithubRepoDetailsFragment : Fragment() {
    private var binding: FragmentGithubRepoDetailsBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_github_repo_details, container, false)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            val response = it.getParcelable<GitFetchResponse>(REPO_DETAILS)
            binding?.repo = response
            binding?.repoOwner = response?.owner
            binding?.executePendingBindings()

        } ?: run {

        }
    }
}