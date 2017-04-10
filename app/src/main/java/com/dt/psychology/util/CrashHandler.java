package com.dt.psychology.util;

import android.content.Context;

/**
 * Created by dnnt9 on 2017/3/17.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private static CrashHandler crashHandler = new CrashHandler();
    private Context mContext;

    private CrashHandler(){}

    private CrashHandler getCrashHandler(){
        return crashHandler;
    }

    public void init(Context context){
        mContext = context;
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
