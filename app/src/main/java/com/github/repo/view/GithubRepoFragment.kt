package com.github.repo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.repo.R
import com.github.repo.model.adapter.GithubRepoAdapter
import com.github.repo.model.adapter.listener.BaseRecyclerAdapterListener
import com.github.repo.model.repositery.GithubRepo
import com.github.repo.model.response.GitFetchResponse
import com.github.repo.view.utils.Constants.RequestKey.REPO_DETAILS
import com.github.repo.viewmodel.GithubRepoViewModel
import kotlinx.android.synthetic.main.fragment_github_repo.*

class GithubRepoFragment : Fragment() {

    private lateinit var githubRepoViewModel: GithubRepoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_github_repo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvListRepo.visibility = View.GONE
        progressBar.visibility = View.VISIBLE

        val repo = GithubRepo()

        githubRepoViewModel = ViewModelProvider(this, GithubRepoViewModelFactory(repo)).get(GithubRepoViewModel::class.java)

        // Downstream updated values from web service
        githubRepoViewModel.getGithubRepos.observe(viewLifecycleOwner, Observer {
            progressBar.visibility = View.GONE
            rvListRepo.visibility = View.VISIBLE
            rvListRepo.setHasFixedSize(true)
            rvListRepo.setItemViewCacheSize(it.size)
            rvListRepo.adapter = GithubRepoAdapter(it, gitRepoListener)
        })
    }

    private val gitRepoListener = object : BaseRecyclerAdapterListener<GitFetchResponse> {
        override fun onClickItem(data: GitFetchResponse, pos: Int) {
            val getActivity = activity as GithubActivity

            val fragment = GithubRepoDetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(REPO_DETAILS, data)
            fragment.arguments = bundle
            GitFetchResponse.bundle = bundle
            getActivity.openFragment(fragment)
        }
    }

    /**
     * ViewModelProvider Factory where here we manufacture(create) instance with argument
     */

    class GithubRepoViewModelFactory(private val githubRepo: GithubRepo) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(GithubRepo::class.java).newInstance(githubRepo)
        }
    }
}