package com.evaly.mvrxsample.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingUtils {
    @BindingAdapter("imageUrl")
    fun setUserImageURL(imageView: ImageView, url: String?) {
        var url = url ?: return
        url = url.replace("\n\r", "")
        val context = imageView.context
        Glide.with(context).load(url).into(imageView)
    }


}