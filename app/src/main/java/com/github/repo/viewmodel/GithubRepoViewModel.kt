package com.github.repo.viewmodel

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.toolbox.NetworkImageView
import com.github.repo.GithubRepoApplication
import com.github.repo.model.adapter.listener.BaseRecyclerAdapterListener
import com.github.repo.model.repositery.GithubRepo
import com.github.repo.model.response.GitFetchResponse

class GithubRepoViewModel(githubRepo: GithubRepo) : ViewModel() {

    // Return updated response
    val getGithubRepos : LiveData<MutableList<GitFetchResponse>> = githubRepo.getPublicReposFromNetwork()


    /**
     *  Clear Application Memory Allocated for ViewModel which is similar to onDestroy in Activity/Fragment
     *  Happens when finish() or onBackPressed() get invoked
     */
    override fun onCleared() {
        super.onCleared()
        Log.e("GithubRepoViewModel", "onCleared")
    }
}