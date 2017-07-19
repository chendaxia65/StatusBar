package com.cz.statusbar.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.cz.statusbar.R;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cz.statusbar.util.StatusBarImpKitKat.java
 * @author: Czhen
 * @date: 2017-05-11 17:03
 */
public class StatusBarImpKitKat implements StatusBarInter {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void setStatusBarTransparent(Activity activity) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    public void setStatusBarTranslucent(Activity activity) {
        setStatusBarColor(activity, ContextCompat.getColor(activity, R.color.translucent));
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void setStatusBarColor(Activity activity, int color) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        FrameLayout rootView = (FrameLayout) activity.findViewById(Window.ID_ANDROID_CONTENT);

        View statusBarView = new View(activity);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        params.gravity = Gravity.TOP;

        statusBarView.setBackgroundColor(color);
        rootView.addView(statusBarView, params);
    }

    private int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
}
