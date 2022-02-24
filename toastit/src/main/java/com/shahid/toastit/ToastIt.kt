package com.shahid.toastit

import android.content.Context
import android.content.res.Configuration
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.*

class ToastIt {
    companion object {
        private val LOADED_TOAST_TYPEFACE: Typeface = Typeface.create("sans-serif-condensed", Typeface.NORMAL);
        private var currentTypeface = LOADED_TOAST_TYPEFACE
        private var textSize = 16
        private var tintIcon = true
        private var allowQueue = true
        private var toastGravity = -1
        private var xOffset = -1
        private var yOffset = -1
        private var supportDarkTheme = true
        private var isRTL = false
        private var shadowOptions = ShadowOptions.NONE
        private var lastToast:Toast? = null
        val LENGTH_SHORT = Toast.LENGTH_SHORT
        val LENGTH_LONG = Toast.LENGTH_LONG


        @JvmStatic
        @CheckResult
        fun normal(context: Context, @StringRes message: Int): Toast{
            return normal(context, context.getString(message), Toast.LENGTH_SHORT, null, false)
        }

        @JvmStatic
        @CheckResult
        fun normal(context: Context, @StringRes message: Int, icon: Drawable?): Toast {
            return normal(context, context.getString(message), Toast.LENGTH_SHORT, icon, true);
        }

        @JvmStatic
        @CheckResult
        fun normal(context: Context, message: CharSequence, icon: Drawable?): Toast {
            return normal(context, message, Toast.LENGTH_SHORT, icon, true);
        }

        @JvmStatic
        @CheckResult
        fun normal(context: Context, @StringRes message: Int, duration: Int): Toast {
            return normal(context, context.getString(message), duration, null, false);
        }

        @JvmStatic
        @CheckResult
        fun normal(context: Context, message: CharSequence, duration: Int): Toast {
            return normal(context, message, duration, null, false);
        }

        @JvmStatic
        @CheckResult
        fun normal(context: Context, @StringRes message: Int, duration: Int, icon: Drawable?): Toast {
            return normal(context, context.getString(message), duration, icon, true);
        }

        @JvmStatic
        @CheckResult
        fun normal(context: Context, message: CharSequence, duration: Int,
                   icon: Drawable?): Toast {
            return normal(context, message, duration, icon, true);
        }

        @JvmStatic
        @CheckResult
        fun normal(context: Context, @StringRes message: Int, duration: Int, icon: Drawable?, withIcon: Boolean): Toast {
            return normalWithDarkThemeSupport(context, context.getString(message), icon, duration, withIcon);
        }

        @JvmStatic
        @CheckResult
        fun normal(context: Context, message: CharSequence, duration: Int, icon: Drawable?, withIcon: Boolean): Toast {
            return normalWithDarkThemeSupport(context, message, icon, duration, withIcon);
        }


        @JvmStatic
        @CheckResult
        fun warning(context: Context, @StringRes message: Int): Toast {
            return warning(context, context.getString(message), Toast.LENGTH_SHORT, true)
        }

        @JvmStatic
        @CheckResult
        fun warning(context: Context, message: CharSequence): Toast {
            return warning(context, message, Toast.LENGTH_SHORT, true)
        }

        @JvmStatic
        @CheckResult
        fun warning(context: Context, @StringRes message: Int, duration: Int): Toast {
            return warning(context, context.getString(message), duration, true)
        }

        @JvmStatic
        @CheckResult
        fun warning(context: Context, message: CharSequence, duration: Int): Toast {
            return warning(context, message, duration, true)
        }

        @JvmStatic
        @CheckResult
        fun warning(context: Context, @StringRes message: Int, duration: Int, withIcon: Boolean): Toast {
            return ToastIt.custom(
                context,
                context.getString(message),
                ToastUtils.getDrawable(context, R.drawable.ic_error_outline_white_24dp),
                ToastUtils.getColor(context, R.color.warningColor),
                ToastUtils.getColor(context, R.color.defaultTextColor),
                duration,
                withIcon,
                true
            )
        }

        @JvmStatic
        @CheckResult
        fun warning(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
            return ToastIt.custom(
                context,
                message,
                ToastUtils.getDrawable(context, R.drawable.ic_error_outline_white_24dp),
                ToastUtils.getColor(context, R.color.warningColor),
                ToastUtils.getColor(context, R.color.defaultTextColor),
                duration,
                withIcon,
                true
            )
        }

        @JvmStatic
        @CheckResult
        fun info(context: Context, @StringRes message: Int): Toast {
            return info(context, context.getString(message), Toast.LENGTH_SHORT, true)
        }

        @JvmStatic
        @CheckResult
        fun info(context: Context, message: CharSequence): Toast {
            return info(context, message, Toast.LENGTH_SHORT, true)
        }

        @JvmStatic
        @CheckResult
        fun info(context: Context, @StringRes message: Int, duration: Int): Toast {
            return info(context, context.getString(message), duration, true)
        }

        @JvmStatic
        @CheckResult
        fun info(context: Context, message: CharSequence, duration: Int): Toast {
            return info(context, message, duration, true)
        }

        @JvmStatic
        @CheckResult
        fun info(
            context: Context,
            @StringRes message: Int,
            duration: Int,
            withIcon: Boolean
        ): Toast {
            return ToastIt.custom(
                context,
                context.getString(message),
                ToastUtils.getDrawable(context, R.drawable.ic_info_outline_white_24dp),
                ToastUtils.getColor(context, R.color.infoColor),
                ToastUtils.getColor(context, R.color.defaultTextColor),
                duration,
                withIcon,
                true
            )
        }

        @JvmStatic
        @CheckResult
        fun info(
            context: Context,
            message: CharSequence,
            duration: Int,
            withIcon: Boolean
        ): Toast {
            return ToastIt.custom(
                context,
                message,
                ToastUtils.getDrawable(context, R.drawable.ic_info_outline_white_24dp),
                ToastUtils.getColor(context, R.color.infoColor),
                ToastUtils.getColor(context, R.color.defaultTextColor),
                duration,
                withIcon,
                true
            )
        }

        @JvmStatic
        @CheckResult
        fun success(context: Context, @StringRes message: Int): Toast {
            return success(context, context.getString(message), Toast.LENGTH_SHORT, true)
        }

        @JvmStatic
        @CheckResult
        fun success(context: Context, message: CharSequence): Toast {
            return success(context, message, Toast.LENGTH_SHORT, true)
        }

        @JvmStatic
        @CheckResult
        fun success(context: Context, @StringRes message: Int, duration: Int): Toast {
            return success(context, context.getString(message), duration, true)
        }

        @JvmStatic
        @CheckResult
        fun success(context: Context, message: CharSequence, duration: Int): Toast {
            return success(context, message, duration, true)
        }

        @JvmStatic
        @CheckResult
        fun success(
            context: Context,
            @StringRes message: Int,
            duration: Int,
            withIcon: Boolean
        ): Toast {
            return ToastIt.custom(
                context,
                context.getString(message),
                ToastUtils.getDrawable(context, R.drawable.ic_check_white_24dp),
                ToastUtils.getColor(context, R.color.successColor),
                ToastUtils.getColor(context, R.color.defaultTextColor),
                duration,
                withIcon,
                true
            )
        }

        @JvmStatic
        @CheckResult
        fun success(
            context: Context,
            message: CharSequence,
            duration: Int,
            withIcon: Boolean
        ): Toast {
            return ToastIt.custom(
                context,
                message,
                ToastUtils.getDrawable(context, R.drawable.ic_check_white_24dp),
                ToastUtils.getColor(context, R.color.successColor),
                ToastUtils.getColor(context, R.color.defaultTextColor),
                duration,
                withIcon,
                true
            )
        }

        @JvmStatic
        @CheckResult
        fun error(context: Context, @StringRes message: Int): Toast {
            return error(context, context.getString(message), Toast.LENGTH_SHORT, true)
        }

        @JvmStatic
        @CheckResult
        fun error(context: Context, message: CharSequence): Toast {
            return error(context, message, Toast.LENGTH_SHORT, true)
        }

        @JvmStatic
        @CheckResult
        fun error(context: Context, @StringRes message: Int, duration: Int): Toast {
            return error(context, context.getString(message), duration, true)
        }

        @JvmStatic
        @CheckResult
        fun error(context: Context, message: CharSequence, duration: Int): Toast {
            return error(context, message, duration, true)
        }

        @JvmStatic
        @CheckResult
        fun error(
            context: Context,
            @StringRes message: Int,
            duration: Int,
            withIcon: Boolean
        ): Toast {
            return ToastIt.custom(
                context,
                context.getString(message),
                ToastUtils.getDrawable(context, R.drawable.ic_clear_white_24dp),
                ToastUtils.getColor(context, R.color.errorColor),
                ToastUtils.getColor(context, R.color.defaultTextColor),
                duration,
                withIcon,
                true
            )
        }

        @JvmStatic
        @CheckResult
        fun error(
            context: Context,
            message: CharSequence,
            duration: Int,
            withIcon: Boolean
        ): Toast {
            return ToastIt.custom(
                context,
                message,
                ToastUtils.getDrawable(context, R.drawable.ic_clear_white_24dp),
                ToastUtils.getColor(context, R.color.errorColor),
                ToastUtils.getColor(context, R.color.defaultTextColor),
                duration,
                withIcon,
                true
            )
        }

        @JvmStatic
        @CheckResult
        fun custom(context: Context, @StringRes message: Int, icon: Drawable,
                   duration: Int, withIcon: Boolean): Toast {
            return custom(context, context.getString(message), icon, -1, ToastUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, false)
        }

        @JvmStatic
        @CheckResult
        fun custom(context: Context, message: CharSequence, icon: Drawable,
                   duration: Int, withIcon: Boolean) : Toast{
            return custom(context, message, icon, -1, ToastUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, false)
        }

        @JvmStatic
        @CheckResult
        fun custom(context: Context, @StringRes message: Int, @DrawableRes iconRes: Int,
                   @ColorRes tintColorRes: Int, duration: Int,
                   withIcon: Boolean, shouldTint: Boolean): Toast {
            return custom(context, context.getString(message), ToastUtils.getDrawable(context, iconRes),
                ToastUtils.getColor(context, tintColorRes), ToastUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, shouldTint)
        }

        @JvmStatic
        @CheckResult
        fun custom(context: Context, message: CharSequence, @DrawableRes iconRes: Int,
                   @ColorRes tintColorRes: Int, duration: Int,
                   withIcon: Boolean, shouldTint: Boolean): Toast {
            return custom(context, message, ToastUtils.getDrawable(context, iconRes),
                ToastUtils.getColor(context, tintColorRes), ToastUtils.getColor(context, R.color.defaultTextColor),
                duration, withIcon, shouldTint)
        }

        @JvmStatic
        @CheckResult
        fun custom(context: Context, @StringRes message: Int, icon: Drawable?,
                   @ColorRes tintColorRes: Int, duration: Int, withIcon: Boolean, shouldTint: Boolean): Toast {
            return custom(context, context.getString(message), icon, ToastUtils.getColor(context, tintColorRes),
                ToastUtils.getColor(context, R.color.defaultTextColor), duration, withIcon, shouldTint)
        }

        @JvmStatic
        @CheckResult
        fun custom(context: Context, @StringRes message: Int, icon: Drawable,
                   @ColorRes tintColorRes: Int, @ColorRes textColorRes: Int,
                   duration: Int, withIcon: Boolean, shouldTint: Boolean): Toast {
            return custom(context, context.getString(message), icon, ToastUtils.getColor(context, tintColorRes),
                ToastUtils.getColor(context, textColorRes), duration, withIcon, shouldTint)
        }

        @JvmStatic
        @CheckResult
        fun custom(context: Context, message: CharSequence, icon: Drawable?,
                   @ColorInt tintColor: Int, @ColorInt textColor: Int, duration: Int,
                   withIcon: Boolean, shouldTint: Boolean): Toast{
            val currentToast = Toast.makeText(context, "", duration)
            val toastLayout = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.toast_layout, null)
            val toastRoot = toastLayout.findViewById<LinearLayout>(R.id.toast_root)
            val toastIcon = toastLayout.findViewById<ImageView>(R.id.toast_icon)
            val toastTextView = toastLayout.findViewById<TextView>(R.id.toast_text)
            var drawableFrame: Drawable? = null
            drawableFrame = if (shouldTint){
                ToastUtils.tint9PatchDrawableFrame(context, tintColor)
            }else{
                ToastUtils.getDrawable(context, R.drawable.toast_frame)
            }
            ToastUtils.setBackground(toastLayout, drawableFrame)
            if (withIcon){
                if (icon == null){
                    throw IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true")
                }
                if (isRTL && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
                    toastRoot.layoutDirection = View.LAYOUT_DIRECTION_RTL
                }
                ToastUtils.setBackground(toastIcon, if (tintIcon) ToastUtils.tintIcon(icon, textColor) else icon)
            }else{
                toastIcon.visibility = View.GONE
            }

            toastTextView.text = message
            toastTextView.setTextColor(textColor)
            toastTextView.setTypeface(currentTypeface)
            toastTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.toFloat())
            toastTextView.setShadowLayer(
                shadowOptions.radius.toFloat(),
                shadowOptions.dx.toFloat(),
                shadowOptions.dy.toFloat(),
                shadowOptions.color
            )
            currentToast.view = toastLayout

            if (!allowQueue){
                lastToast?.cancel()
                lastToast = currentToast
            }
            currentToast.setGravity(
                if (toastGravity == -1) currentToast.gravity else toastGravity,
                if (xOffset == -1) currentToast.xOffset else xOffset,
                if (yOffset == -1) currentToast.yOffset else yOffset,
            )
            return currentToast
        }

        private fun normalWithDarkThemeSupport(context: Context, message: CharSequence, icon: Drawable?, duration: Int, withIcon: Boolean): Toast{
            if (supportDarkTheme && Build.VERSION.SDK_INT >= 29) {
                val uiMode = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                if (uiMode == Configuration.UI_MODE_NIGHT_NO) {
                    return withLightTheme(context, message, icon, duration, withIcon);
                }
                return withDarkTheme(context, message, icon, duration, withIcon);
            } else {
                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                    withLightTheme(context, message, icon, duration, withIcon);
                } else {
                    withDarkTheme(context, message, icon, duration, withIcon);
                }
            }
        }
        private fun withLightTheme(context: Context, message: CharSequence,
                                   icon: Drawable?, duration: Int, withIcon: Boolean): Toast{
            return custom(context, message, icon, ToastUtils.getColor(context, R.color.defaultTextColor),
                ToastUtils.getColor(context, R.color.normalColor), duration, withIcon, true);

        }
        private fun withDarkTheme(context: Context, message: CharSequence,
                                  icon: Drawable?, duration: Int, withIcon: Boolean): Toast{
            return custom(context, message, icon, ToastUtils.getColor(context, R.color.normalColor),
                ToastUtils.getColor(context, R.color.defaultTextColor), duration, withIcon, true)
        }

    }

    class Config{
        private var typeface = ToastIt.currentTypeface
        private var textSize = ToastIt.textSize
        private var tintIcon = ToastIt.tintIcon
        private var allowQueue = true
        private var toastGravity = ToastIt.toastGravity
        private var xOffset = ToastIt.xOffset
        private var yOffset = ToastIt.yOffset
        private var supportDarkTheme = true
        private var isRTL = false
        private var shadowOptions = ToastIt.shadowOptions

        companion object {
            @JvmStatic
            fun getInstance(): Config{
                return Config()
            }

            @JvmStatic
            fun reset(){
                ToastIt.currentTypeface = LOADED_TOAST_TYPEFACE
                ToastIt.textSize = 16
                ToastIt.tintIcon = true
                ToastIt.allowQueue = true
                ToastIt.toastGravity = -1
                ToastIt.xOffset = -1
                ToastIt.yOffset = -1
                ToastIt.supportDarkTheme = true
                ToastIt.isRTL = false
                ToastIt.shadowOptions = ShadowOptions.NONE
            }
        }

        @CheckResult
        fun setToastTypeface(typeface: Typeface): Config{
            this.typeface = typeface
            return this
        }

        @CheckResult
        fun setTextSize(sizeInSp: Int): Config{
            this.textSize = sizeInSp
            return this
        }

        @CheckResult
        fun tintIcon(tintIcon: Boolean): Config {
            this.tintIcon = tintIcon
            return this
        }

        @CheckResult
        fun allowQueue(allowQueue: Boolean): Config{
            this.allowQueue = allowQueue
            return this
        }

        @CheckResult
        fun setGravity(gravity: Int, xOffset: Int, yOffset: Int): Config {
            this.toastGravity = gravity;
            this.xOffset = xOffset;
            this.yOffset = yOffset;
            return this;
        }

        @CheckResult
        fun setGravity(gravity: Int) : Config{
            this.toastGravity = gravity;
            return this;
        }

        @CheckResult
        fun supportDarkTheme(supportDarkTheme: Boolean): Config {
            this.supportDarkTheme = supportDarkTheme;
            return this;
        }

        @CheckResult
        fun setShadow(shadowOptions: ShadowOptions): Config {
            this.shadowOptions = shadowOptions;
            return this;
        }

        @CheckResult
        fun setRTL(isRTL: Boolean): Config {
            this.isRTL = isRTL;
            return this;
        }

        fun apply() {
            ToastIt.currentTypeface = typeface;
            ToastIt.textSize = textSize;
            ToastIt.tintIcon = tintIcon;
            ToastIt.allowQueue = allowQueue;
            ToastIt.toastGravity = toastGravity;
            ToastIt.xOffset = xOffset;
            ToastIt.yOffset = yOffset;
            ToastIt.supportDarkTheme = supportDarkTheme;
            ToastIt.isRTL = isRTL;
            ToastIt.shadowOptions = shadowOptions;
        }
    }
}