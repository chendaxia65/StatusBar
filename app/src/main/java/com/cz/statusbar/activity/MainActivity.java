package com.cz.statusbar.activity;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cz.statusbar.R;
import com.cz.statusbar.util.StatusBarUtil;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBarUtil.changeStatusBarIconsColor(this, ContextCompat.getColor(this, R.color.colorAccent));
        StatusBarUtil.setStatusBarMode(this, StatusBarUtil.STATUSBAR_TRANSPARENT);

        mToolbar = (Toolbar) findViewById(R.id.tool_bar);

    }


    public void onClick(View v) {
        int color = ContextCompat.getColor(this, R.color.colorAccent);
        switch (v.getId()) {
            case R.id.color_pink:
                color = ContextCompat.getColor(this, R.color.colorAccent);
                break;
            case R.id.color_white:
                color = Color.WHITE;
                break;
            case R.id.color_black:
                color = Color.BLACK;
                break;
            case R.id.color_blue:
                color = ContextCompat.getColor(this, R.color.colorPrimary);
                break;
        }

        mToolbar.setBackgroundColor(color);
        StatusBarUtil.changeStatusBarIconsColor(this, color);
    }
}
