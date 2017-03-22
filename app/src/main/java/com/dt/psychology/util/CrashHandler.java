package com.dt.psychology.util;

/**
 * Created by dnnt9 on 2017/3/17.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private Thread.UncaughtExceptionHandler mHandler;

    public CrashHandler(){
        mHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

    }
}
