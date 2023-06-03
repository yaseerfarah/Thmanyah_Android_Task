package com.yasser.thmanyahtask.core.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import java.util.*

internal fun View.visible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

internal fun Context.getResourcesByLocal(language: String): Context {
    val conf: Configuration = resources.configuration
    conf.locale = Locale(language)
    return createConfigurationContext(conf)
}

internal fun Button.setVectorDrawableEnd(resourceId: Int) {
    setCompoundDrawablesRelativeWithIntrinsicBounds(
        null,
        null,
        context.setVectorForPreLollipop(resourceId),
        null
    )
}

@SuppressLint("ObsoleteSdkInt", "UseCompatLoadingForDrawables")
internal fun Context.setVectorForPreLollipop(resourceId: Int): Drawable? {
    return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        VectorDrawableCompat.create(resources, resourceId, null)
    } else {
        resources.getDrawable(resourceId, null)
    }
}

internal val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
internal val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()



internal fun Context.getColorRes(@ColorRes res: Int) = ContextCompat.getColor(this, res)


internal infix fun View?.onClick(action: (() -> Unit)?) {
    this?.setOnClickListener { action?.invoke() }
}


fun ImageView.loadImage(
    imageUrl: String,
    placeholderDrawable: Drawable? = null,
    progressBar: ProgressBar?
) {

    val theImage = GlideUrl(
        imageUrl, LazyHeaders.Builder()
            .addHeader("User-Agent", "5")
            .build()
    )
    Glide.with(this)
        .load(theImage)
        .error(placeholderDrawable)
        .apply(RequestOptions.timeoutOf(60*1000))
        .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                //Log.e("Load Image",e!!.message!!)
                progressBar?.visible(false)
                return false
            }

            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {

                progressBar?.visible(false)
                return false
            }

        })
        .into(this)
}

