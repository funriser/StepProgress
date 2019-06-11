package com.funrisestudio.stepprogress

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import com.funrisestudio.stepprogress.R

class DrawableHelper {

    fun createStrokeOvalDrawable(context: Context, color: Int): Drawable {
        val strokeWidth = SViewUtils.toPx(2, context)
        return GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setStroke(strokeWidth, color)
        }
    }

    fun createOvalDrawable(color: Int): Drawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setColor(color)
        }
    }

    fun createCheckDrawable(context: Context, color: Int): Drawable {
        val checkDrawable = context.getDrawable(R.drawable.ic_check)
        return LayerDrawable(arrayOf(createOvalDrawable(color), checkDrawable)).apply {
            val ins = SViewUtils.toPx(15, context)
            setLayerInset(1, ins, ins, ins, ins)
        }
    }

}