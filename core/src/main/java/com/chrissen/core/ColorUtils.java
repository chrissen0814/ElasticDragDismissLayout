package com.chrissen.core;

import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;

/**
 * Function:
 * <br/>
 * Describe:
 * <br/>
 * Author: chris on 2019/2/21.
 * <br/>
 * Email: chrissen0814@gmail.com
 */

public class ColorUtils {

    /**
     * Set the alpha component of {@code color} to be {@code alpha}.
     */
    public static @CheckResult @ColorInt int modifyAlpha(@ColorInt int color,
                                                         @FloatRange(from = 0f, to = 1f) float alpha) {
        return modifyAlpha(color, (int) (255f * alpha));
    }

    /**
     * Set the alpha component of {@code color} to be {@code alpha}.
     */
    public static @CheckResult
    @ColorInt int modifyAlpha(@ColorInt int color,
                    @IntRange(from = 0, to = 255) int alpha) {
        return (color & 0x00ffffff) | (alpha << 24);
    }

}
