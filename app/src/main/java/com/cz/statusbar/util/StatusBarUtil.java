package com.cz.statusbar.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cz.statusbar.StatusBarUtil.java
 * @author: Czhen
 * @date: 2017-05-11 14:31
 */
public class StatusBarUtil {

    private static StatusBarInter statusBarInter;

    public static final int STATUSBAR_TRANSPARENT = 0;

    public static final int STATUSBAR_TRANSLUCENT = 1;

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            statusBarInter = new StatusBarImplLollipop();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            statusBarInter = new StatusBarImpKitKat();
        }
    }

    /**
     * <p/>
     * The value should be one or more of the following fields combined with
     * bitwise-or:
     * {@link StatusBarUtil#STATUSBAR_TRANSPARENT},
     * {@link StatusBarUtil#STATUSBAR_TRANSLUCENT}.
     * <p/>
     */
    public static void setStatusBarMode(Activity activity, int mode) {
        if (mode == STATUSBAR_TRANSPARENT)
            setStatusBarTransparent(activity);
        else if (mode == STATUSBAR_TRANSLUCENT)
            setStatusBarTranslucent(activity);
    }

    /**
     * 设置状态栏全透明
     *
     * @param activity
     */
    private static void setStatusBarTransparent(Activity activity) {
        if (statusBarInter != null) {
            statusBarInter.setStatusBarTransparent(activity);
        }
    }

    /**
     * 设置状态栏半透明
     *
     * @param activity
     */
    private static void setStatusBarTranslucent(Activity activity) {
        if (statusBarInter != null) {
            statusBarInter.setStatusBarTranslucent(activity);
        }
    }


    public static void setFitsSystemWindow(Activity activity, boolean isFits) {
        FrameLayout rootView = (FrameLayout) activity.findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = rootView.getChildAt(0);
        if (mChildView != null) {
            mChildView.setFitsSystemWindows(isFits);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public static void changeStatusBarIconsColor(Activity activity, int color) {
        setLightStatusBarFlag(activity, isLightColor(color));
    }

    private static boolean isLightColor(int color) {
        int blue = Color.blue(color);
        int green = Color.green(color);
        int red = Color.red(color);
        return ((red * 38 + green * 75 + blue * 15) >> 7) > 225;
    }

    @TargetApi(Build.VERSION_CODES.M)
    private static void setLightStatusBarFlag(Activity activity, boolean isLightColor) {

        int ui = activity.getWindow().getDecorView().getWindowSystemUiVisibility();

        if (isLightColor) {
            ui |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        } else {
            ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }

        activity.getWindow().getDecorView().setSystemUiVisibility(ui);
    }
}
