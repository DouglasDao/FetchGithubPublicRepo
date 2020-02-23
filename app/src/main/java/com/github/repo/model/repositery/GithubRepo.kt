package com.github.repo.model.repositery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request.Method.GET
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.github.repo.GithubRepoApplication
import com.github.repo.model.response.GitFetchResponse
import com.github.repo.view.utils.Constants.HttpUrls.GITHUB_PUBLIC_REPO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 * @Repo Layer - Should only have Network/Database Calls also this class can be object class for ease access
 * */

class GithubRepo {

    private val gitFetchLiveData = MutableLiveData<MutableList<GitFetchResponse>>()

    fun getPublicReposFromNetwork(): LiveData<MutableList<GitFetchResponse>> {

        // Success Response Listener
        val githubRepoListener = Response.Listener<String> { response ->
            val responseType = object : TypeToken<MutableList<GitFetchResponse>?>() {}.type

            // Change Event Dispatched by modifying the liveData using setValue/postValue
            gitFetchLiveData.value = getObjectFromJsonResponseString(response, responseType)
        }

        // Error Listener
        val errorListener = Response.ErrorListener {
            Log.e("GithubRepo","Error Message :"+it.localizedMessage)
        }

        // Network Call
        val stringRequest = StringRequest(GET, GITHUB_PUBLIC_REPO, githubRepoListener, errorListener)
        GithubRepoApplication.getInstance()?.addToRequestQueue(stringRequest, "GithubPublicRepoAPI")

        return gitFetchLiveData
    }

    /**
     *  Response Object mapping from Json string response
     * */
    private fun getObjectFromJsonResponseString(jsonString: String?, responseType: Type?): MutableList<GitFetchResponse>? {
        try {
            return Gson().fromJson(jsonString, responseType)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        return null
    }
}