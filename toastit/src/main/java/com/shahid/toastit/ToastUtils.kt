package com.shahid.toastit

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.NinePatchDrawable
import android.os.Build
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat

object ToastUtils {
    fun tintIcon(drawable: Drawable, @ColorInt tintColor: Int): Drawable{
        drawable.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(tintColor, BlendModeCompat.SRC_IN)
        return drawable
    }

    fun tint9PatchDrawableFrame(context: Context, @ColorInt tintColor: Int): Drawable{
        val toastDrawable = ContextCompat.getDrawable(context, R.drawable.toast_frame) as NinePatchDrawable
        return tintIcon(toastDrawable, tintColor)
    }

    fun setBackground(view: View, drawable: Drawable){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            view.background = drawable
        }else{
            view.setBackgroundDrawable(drawable)
        }
    }
    fun getDrawable(context: Context, @DrawableRes id: Int): Drawable{
        return AppCompatResources.getDrawable(context, id)!!
    }

    fun getColor(context: Context, @ColorRes color: Int): Int{
        return ContextCompat.getColor(context, color)
    }
}