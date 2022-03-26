package com.example.databinding2

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object ImageViewBindingAdapter {

    @BindingAdapter("image")
    @JvmStatic
    fun setImage(imageView: ImageView, url: String) {
        Picasso.get().load(url).into(imageView)
    }

    @BindingAdapter(value = ["image", "defaultImageResource"], requireAll = false)
    @JvmStatic
    fun setImage(imageView: ImageView, url: String, localUrl: Int) {
        if (url.isNullOrEmpty()) {
            imageView.setImageResource(localUrl)

        } else {
            Picasso.get().load(url).into(imageView)
        }
    }

}