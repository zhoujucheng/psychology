package com.dt.psychology.util;

import android.util.Log;

import com.dt.psychology.domain.Json;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

/**
 * Created by dnnt9 on 2017/4/4.
 */

public abstract class MyObserver<T extends Json> implements Observer<Response<T>>{

    @Override
    public void onSubscribe(Disposable disposable) {}

    @Override
    public void onNext(Response<T> tResponse) {
        if (tResponse == null)  throw new NullPointerException("无response返回");
        if (tResponse.isSuccessful()){
            T t = tResponse.body();
            if (t == null)  throw new NullPointerException("服务器数据出错");
            if (t.isSuccessful()) onSuccess(t);
            else {
                if(t.getMessage() != null)  errorMsg(t.getMessage());
                else errorMsg("服务器出错");
            }
        }else errorMsg("服务器出错");
    }

    @Override
    public void onError(Throwable throwable) {
        if ((throwable instanceof NullPointerException) || (throwable instanceof IllegalArgumentException)) {
            // that's likely a bug in the application
            Thread.currentThread().getUncaughtExceptionHandler()
                    .uncaughtException(Thread.currentThread(),throwable);
            return;
        }
        if (throwable instanceof IllegalStateException) {
            // that's a bug in RxJava or in a custom operator
            Thread.currentThread().getUncaughtExceptionHandler()
                    .uncaughtException(Thread.currentThread(),throwable);
            return;
        }
        if (throwable instanceof NetworkUnavailableException){
            errorMsg(throwable.getMessage());
        }else if (throwable instanceof IOException || throwable instanceof HttpException){
            errorMsg("网络出错");
        }else {
            errorMsg("发生未知错误");
        }
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {}

    public abstract void onSuccess(T t);

    public abstract void errorMsg(String msg);
}
