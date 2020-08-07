package com.github.repo.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.github.repo.R
import com.github.repo.model.adapter.ImageLoadingAdapter
import com.github.repo.model.adapter.listener.BaseRecyclerAdapterListener
import com.github.repo.view.utils.Constants.BundleKey.IMG_RESOURCE
import kotlinx.android.synthetic.main.activity_image_list.*


class ImageListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_list)
        setAdapter()
    }

    private fun setAdapter() {
        val gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        rvImageList.layoutManager = gridLayoutManager
        rvImageList.adapter = ImageLoadingAdapter(getImageList(), iImageClickListener)
    }

    private fun getImageList(): ArrayList<Int> {
        val list = arrayListOf<Int>()
        for (i in 1..1000) {
            list.add(R.drawable.walllpaper_hd)
        }
        return list
    }

    private val iImageClickListener = object : BaseRecyclerAdapterListener<Int> {
        override fun onClickItem(data: Int, pos: Int) {
            val intent = Intent(this@ImageListActivity, ImageDetailsActivity::class.java)
            intent.putExtra(IMG_RESOURCE, data)
            startActivity(intent)
        }
    }

}
