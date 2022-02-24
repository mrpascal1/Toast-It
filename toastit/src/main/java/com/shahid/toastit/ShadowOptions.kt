package com.shahid.toastit

import android.graphics.Color
import androidx.annotation.CheckResult

class ShadowOptions(
    @get:CheckResult val radius: Int,
    @get:CheckResult val dx: Int,
    @get:CheckResult val dy: Int,
    @get:CheckResult val color: Int
) {

    companion object {
        var NONE = ShadowOptions(0, 0, 0, 0)

        /**
         * A drop shadow suitable far from the text to aid legibility
         */
        var DROP_SHADOW = ShadowOptions(8, 5, 5, Color.BLACK)

        /**
         * An outer 'glow'
         */
        var OUTER_GLOW = ShadowOptions(3, 0, 0, Color.WHITE)
    }
}