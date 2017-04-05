package com.dt.psychology.ui.views;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.dt.psychology.ui.MyApplication;

/**
 * Created by dnnt9 on 2017/3/21.
 */

public interface BaseView {
    void showToast(String text);
    void showToast(int id);
    Context getContext();
    MyApplication getMyApplication();
    void startActivity(Class<?> cls);
    void activityFinish();
    AlertDialog showDialogWithBar(String title);
    void showDialog(String title,String content);

}
