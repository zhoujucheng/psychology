package com.dt.psychology.util;

import com.dt.psychology.domain.Json;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by dnnt9 on 2017/4/8.
 */

public abstract class JsonObserver<T extends Json> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {}

    @Override
    public void onError(Throwable e) {
        if (e instanceof NullPointerException
                || e instanceof IllegalArgumentException
                || e instanceof IllegalStateException) {
            Thread.currentThread().getUncaughtExceptionHandler()
                    .uncaughtException(Thread.currentThread(),e);
            return;
        }
        if (e instanceof NetworkUnavailableException
                || e instanceof OperationFailureException
                || e instanceof ServerException){
            errorMsg(e.getMessage());
        }else {
            errorMsg("网络出错");
        }
    }

    @Override
    public void onComplete() {}

    public abstract void errorMsg(String msg);
}
