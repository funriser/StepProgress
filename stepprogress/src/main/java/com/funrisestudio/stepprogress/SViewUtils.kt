package com.funrisestudio.stepprogress

import android.content.Context
import android.util.DisplayMetrics

object SViewUtils {

    fun toDp(px: Int, context: Context) =
            px / (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)

    fun toPx(dp: Int, context: Context) =
            dp * (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)

    fun toPx(dp: Float, context: Context) =
        dp * (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)

}