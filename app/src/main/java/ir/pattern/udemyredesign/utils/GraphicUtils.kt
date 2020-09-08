package ir.pattern.udemyredesign.utils

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.provider.Settings
import android.text.TextUtils
import android.util.DisplayMetrics
import android.view.View
import androidx.annotation.DrawableRes
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import java.io.Serializable

class GraphicUtils
constructor(
    val context: Context
) {

    companion object {
        class Dimension(var width: Int, var height: Int) : Serializable
    }

    // TODO heck method body
    fun convertDrawableToBitmap(drawable: Drawable?): Bitmap? {
        if (drawable == null) {
            return null
        }
        val bitmap: Bitmap?
        val width =
            if (drawable.bounds.right <= 0) convertDPtoPixel(64f).toInt() else drawable.bounds.right
        val height =
            if (drawable.bounds.bottom <= 0) convertDPtoPixel(64f).toInt() else drawable.bounds.bottom
        if (drawable is BitmapDrawable) {
            bitmap = drawable.bitmap
            if (bitmap == null) {
                return null
            }
        } else {
            bitmap = Bitmap.createBitmap(
                drawable.intrinsicWidth, drawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)
        }

        // Recycle 'bitmap'
        // todo recycle bitmap
//		if (scaledBitmap != bitmap) {
//			bitmap.recycle();
//		}
        return Bitmap.createScaledBitmap(bitmap, width, height, false)
    }

    /**
     * @return Configuration.ORIENTATION_PORTRAIT or Configuration.ORIENTATION_LANDSCAPE
     */
    fun getScreenOrientation(): Int {
        return context.getResources().getConfiguration().orientation
    }

    // TODO Why we use this method instead of getScreenOrientation()
//	public static int getOrientation(Activity activity) {
//		Pair<Integer, Integer> display = getScreenResolution(activity);
//
//		int width = display.first;
//		int height = display.second;
//
//		if (width <= height) {
//			return ORIENTATION_PORTRAIT;
//		} else {
//			return ORIENTATION_LANDSCAPE;
//		}
//	}

    // TODO Why we use this method instead of getScreenOrientation()
    //	public static int getOrientation(Activity activity) {
    //		Pair<Integer, Integer> display = getScreenResolution(activity);
    //
    //		int width = display.first;
    //		int height = display.second;
    //
    //		if (width <= height) {
    //			return ORIENTATION_PORTRAIT;
    //		} else {
    //			return ORIENTATION_LANDSCAPE;
    //		}
    //	}
    fun getScreenResolution(activity: Activity): Dimension {
        var height = 0
        var width = 0
        val displaymetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displaymetrics)
        height = displaymetrics.heightPixels
        width = displaymetrics.widthPixels
        return Dimension(width, height)
    }

    fun getScreenResolution(): Dimension {
        var height = 0
        var width = 0
        val displaymetrics: DisplayMetrics = context.getResources().getDisplayMetrics()
        height = displaymetrics.heightPixels
        width = displaymetrics.widthPixels

        return Dimension(width, height)
    }

    fun getAppScreenResolution(activity: Activity): Dimension {
        var height = 0
        var width = 0
        val display = activity.windowManager.defaultDisplay
        val rect = Rect()
        display.getRectSize(rect)
        width = rect.width()
        height = rect.height()
        return Dimension(width, height)
    }


    fun getScreenWidthDip(activity: Activity): Float {
        var width = 0f
        val displaymetrics = activity.resources.displayMetrics
        width = displaymetrics.widthPixels / displaymetrics.density
        return width
    }

    fun getScreenWidthDip(): Float {
        var width = 0f
        val displaymetrics: DisplayMetrics = context.getResources().getDisplayMetrics()
        width = displaymetrics.widthPixels / displaymetrics.density
        return width
    }

    fun isTabletDevice(): Boolean {
        return context.getResources()
            .getConfiguration().screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device
     * density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need
     * to convert into pixels
     * @return A float value to represent px equivalent to dp depending on
     * device density
     */
    fun convertDPtoPixel(dp: Float): Float {
        val resources: Resources = context.getResources()
        val metrics = resources.displayMetrics
        return dp * (metrics.densityDpi / 160f)
    }

    /**
     * This method converts device specific pixels to density independent
     * pixels.
     *
     * @param px      A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    fun convertPixelsToDp(context: Context, px: Float): Float {
        val resources = context.resources
        val metrics = resources.displayMetrics
        return px / (metrics.densityDpi / 160f)
    }

    fun isColorValid(color: String?): Boolean {
        return if (TextUtils.isEmpty(color)) {
            false
        } else try {
            Color.parseColor(color)
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     *
     * @param color parsed color
     * @param alpha amount of alpha, must be between 0 and 255
     * @return parsed color with alpha
     */
    fun addAlphaToColor(color: Int, alpha: Int): Int {
        return Color.parseColor(
            String.format(
                "#%02x%06X",
                0xFF and alpha,
                0xFFFFFF and color
            )
        )
    }

    fun convertViewToBitmap(v: View, viewIsRendred: Boolean): Bitmap {
        if (!viewIsRendred) {
            v.measure(
                View.MeasureSpec.makeMeasureSpec(
                    1000,
                    View.MeasureSpec.AT_MOST
                ),
                View.MeasureSpec.makeMeasureSpec(
                    2000,
                    View.MeasureSpec.AT_MOST
                )
            )
            v.layout(0, 0, v.measuredWidth, v.measuredHeight)
        }
        val bitmap =
            Bitmap.createBitmap(v.width, v.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        v.draw(canvas)
        return bitmap
    }

    fun getDrawable(
        res: Resources,
        @DrawableRes resId: Int
    ): Drawable? {
        return try {
            VectorDrawableCompat.create(res, resId, null)
        } catch (e: Exception) {
            res.getDrawable(resId)
        }
    }

    fun isAutoRotateEnabled(activity: Activity?): Boolean {
        return activity != null &&
                Settings.System.getInt(
                    activity.contentResolver,
                    "accelerometer_rotation",
                    0
                ) == 1
    }

}