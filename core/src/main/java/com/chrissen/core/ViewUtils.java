package com.chrissen.core;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * Function:
 * <br/>
 * Describe:
 * <br/>
 * Author: chris on 2019/2/21.
 * <br/>
 * Email: chrissen0814@gmail.com
 */

public class ViewUtils {

    /**
     * Determine if the navigation bar will be on the bottom of the screen, based on logic in
     * PhoneWindowManager.
     */
    public static boolean isNavBarOnBottom(@NonNull Context context) {
        final Resources res= context.getResources();
        final Configuration cfg = context.getResources().getConfiguration();
        final DisplayMetrics dm =res.getDisplayMetrics();
        boolean canMove = (dm.widthPixels != dm.heightPixels &&
                cfg.smallestScreenWidthDp < 600);
        return(!canMove || dm.widthPixels < dm.heightPixels);
    }

}
