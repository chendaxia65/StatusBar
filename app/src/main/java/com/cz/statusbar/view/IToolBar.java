package com.cz.statusbar.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.cz.statusbar.view.IToolBar.java
 * @author: Czhen
 * @date: 2017-05-12 13:48
 */
public class IToolBar extends Toolbar {

    private static final String TAG = "IToolBar";


    public IToolBar(Context context) {
        super(context);
    }

    public IToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置背景透明
     *
     * @param alpha
     */
    public void setBackgroundAlpha(@FloatRange(from = 0.0, to = 1.0) float alpha) {
        Log.e(TAG, " alpha = " + (int) (alpha * 225));
        getBackground().mutate().setAlpha((int) (alpha * 225));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int desiredSize = getContext().getResources().getDimensionPixelSize(android.support.v7.appcompat.R.dimen.abc_action_bar_default_height_material);
        int width = resolveSize(0, widthMeasureSpec);
        int barHeight = resolveSize(desiredSize, heightMeasureSpec);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            barHeight += getStatusBarHeight();
            setPadding(getPaddingLeft(), getStatusBarHeight(), getPaddingRight(), getPaddingBottom());
        }
        setMeasuredDimension(width, barHeight);
    }

    /**
     * 获取系统状态栏高度
     *
     * @return
     */
    private int getStatusBarHeight() {
        Resources resources = getContext().getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resourceId);
    }

}
