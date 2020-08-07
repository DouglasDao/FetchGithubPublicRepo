package com.github.repo.view

import android.annotation.SuppressLint
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.repo.R
import com.github.repo.view.utils.Constants.BundleKey.IMG_RESOURCE
import kotlinx.android.synthetic.main.activity_image_details.*


class ImageDetailsActivity : AppCompatActivity() {

    private var scaleGestureDetector: ScaleGestureDetector? = null
    var mScaleFactor = 1.0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_details)
        extrasFromIntents()
        scaleGestureDetector = ScaleGestureDetector(this, ScaleListener())
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        scaleGestureDetector!!.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    @SuppressLint("SetTextI18n")
    private fun extrasFromIntents() {
        val imgResInt = intent.getIntExtra(IMG_RESOURCE, 0)
        ivFullImage.setImageResource(imgResInt)

        val bitmapDrawable = ContextCompat.getDrawable(this, imgResInt) as BitmapDrawable
        tvImgSize.text = "Size : " + bitmapDrawable.bitmap.width + "x" + bitmapDrawable.bitmap.height + " (" + bitmapDrawable.bitmap.byteCount + " bytes)"

    }

    inner class ScaleListener : SimpleOnScaleGestureListener() {
        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
            mScaleFactor *= scaleGestureDetector.scaleFactor
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f))
            ivFullImage.scaleX = mScaleFactor
            ivFullImage.scaleY = mScaleFactor
            return true
        }
    }

}