package com.cz.statusbar.util;

import android.app.Activity;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cz.statusbar.util.StatusBarInter.java
 * @author: Czhen
 * @date: 2017-05-11 17:01
 */
public interface StatusBarInter {

    /**
     * 设置状态栏半透明
     * @param activity
     */
    void setStatusBarTranslucent(Activity activity);

    /**
     * 设置状态栏全透明
     * @param activity
     */
    void setStatusBarTransparent(Activity activity);
}
