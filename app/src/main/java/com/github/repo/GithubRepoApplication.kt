package com.github.repo

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.github.repo.model.response.GitFetchResponse
import com.github.repo.view.utils.BitmapLruCache
import com.google.gson.Gson
import java.lang.reflect.Type

class GithubRepoApplication : Application() {

    private var mImageLoader: ImageLoader? = null

    companion object {
        private var mAppController: GithubRepoApplication? = null
        @Synchronized
        fun getInstance(): GithubRepoApplication? {
            return mAppController
        }
    }

    override fun onCreate() {
        super.onCreate()
        mAppController = this
    }

    private fun getRequestQueue(): RequestQueue {
        return Volley.newRequestQueue(mAppController)
    }

    fun getImageLoader() : ImageLoader?{
        if (mImageLoader == null){
            mImageLoader = ImageLoader(getRequestQueue(), BitmapLruCache(mAppController))
        }
        return mImageLoader
    }

    fun addToRequestQueue(request: StringRequest, tag: String?) {
        request.tag = tag
        getRequestQueue().add(request)
    }
}