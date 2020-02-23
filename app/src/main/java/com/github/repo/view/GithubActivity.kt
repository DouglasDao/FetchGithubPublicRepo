package com.github.repo.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.github.repo.R
import com.github.repo.model.response.GitFetchResponse
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_github_repo.*


class GithubActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_repo)

        botNavView.setOnNavigationItemSelectedListener(this)
        botNavView.selectedItemId = R.id.navigation_github_repo
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.navigation_github_repo -> {
                val fragManager = supportFragmentManager

                for (index in 0 until supportFragmentManager.backStackEntryCount) {
                    if (fragManager.getBackStackEntryAt(index).name == GithubRepoDetailsFragment::class.java.name) {
                        val fragment = GithubRepoDetailsFragment()
                        fragment.arguments = GitFetchResponse.bundle
                        openFragment(fragment)
                        return true
                    }
                }

                openFragment(GithubRepoFragment())
                return true
            }
            R.id.navigation_sample1 -> {
                openFragment(SecondFragment())
                return true
            }
            R.id.navigation_sample2 -> {
                openFragment(ThirdFragment())
                return true
            }
        }
        return false
    }

    fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        if (fragment is GithubRepoFragment || fragment is GithubRepoDetailsFragment) {
            transaction.addToBackStack(fragment.javaClass.name)
        }
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (getCurrentItemId() == R.id.navigation_sample1 || getCurrentItemId() == R.id.navigation_sample2) {
            finish()
        } else {
            if (supportFragmentManager.backStackEntryCount > 0) {
                val popState = supportFragmentManager.popBackStackImmediate(GithubRepoFragment::class.java.name, 0)
                if (!popState)
                    finish()
            } else {
                finish()
            }
        }
    }

    private fun getCurrentItemId(): Int {
        return botNavView.menu.findItem(botNavView.selectedItemId).itemId
    }
}
