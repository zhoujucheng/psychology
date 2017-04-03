package com.dt.psychology.ui.views;

import android.content.Context;

import com.dt.psychology.ui.MyApplication;

/**
 * Created by dnnt9 on 2017/3/21.
 */

public interface BaseView {
    void showToast(String text);
    Context getContext();
    MyApplication getMyApplication();
    void startActivity(Class<?> cls);
    void activityFinish();
}
