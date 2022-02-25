package com.shahid.toastitdemo

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.shahid.toastit.ShadowOptions
import com.shahid.toastit.ToastIt
import com.shahid.toastitdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSuccessToast.setOnClickListener {
            ToastIt.success(this, R.string.success_toast).show()
        }
        binding.buttonErrorToast.setOnClickListener {
            ToastIt.error(this, R.string.error_message, ToastIt.LENGTH_SHORT, true).show()
        }
        binding.buttonInfoToast.setOnClickListener {
            ToastIt.info(this, R.string.info_message, ToastIt.LENGTH_SHORT, true).show()
        }
        binding.buttonWarningToast.setOnClickListener {
            ToastIt.warning(this, R.string.warning_message, ToastIt.LENGTH_SHORT, true).show()
        }
        binding.buttonNormalToastWoIcon.setOnClickListener {
            ToastIt.normal(this, R.string.normal_message_without_icon).show()
        }
        binding.buttonNormalToastWIcon.setOnClickListener {
            val icon = ContextCompat.getDrawable(this, R.drawable.ic_pets_white_48dp)
            ToastIt.normal(this, R.string.normal_message_with_icon, icon).show()
        }
        binding.buttonInfoToastWithFormatting.setOnClickListener {
            ToastIt.info(this, getFormattedMessage()).show()
        }
        binding.buttonCustomConfig.setOnClickListener {
            ToastIt.Config.getInstance()
                .setToastTypeface(Typeface.createFromAsset(assets, "PCap Terminal.otf"))
                .allowQueue(false)
                .apply()
            ToastIt.custom(
                this,
                R.string.custom_message,
                ContextCompat.getDrawable(this, R.drawable.laptop512)!!,
                android.R.color.black,
                android.R.color.holo_green_light,
                ToastIt.LENGTH_SHORT,
                withIcon = true,
                shouldTint = true
            ).show()
            ToastIt.Config.reset() // Use this if you want to use the configuration above only once
        }
        binding.buttonShadowToast.setOnClickListener {
            ToastIt.Config.getInstance().setShadow(ShadowOptions.DROP_SHADOW).apply()
            ToastIt.warning(this, R.string.shadow_message, ToastIt.LENGTH_SHORT).show()
            ToastIt.Config.reset()
        }
    }
    private fun getFormattedMessage(): CharSequence {
        val prefix = "Formatted "
        val highlight = "bold italic"
        val suffix = " text"
        val ssb = SpannableStringBuilder(prefix).append(highlight).append(suffix)
        val prefixLen = prefix.length
        ssb.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            prefixLen, prefixLen + highlight.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return ssb
    }
}