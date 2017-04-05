package com.dt.psychology.util;

import com.dt.psychology.domain.Json;
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
        if (tResponse.isSuccessful()){
            T t = tResponse.body();
            if (t.isSuccessful()) onSuccess(tResponse);
            else errorMsg(t.getMessage());
        }else errorMsg("服务器错误");
    }

    @Override
    public void onError(Throwable throwable) {
        errorMsg("网络出错");
    }

    @Override
    public void onComplete() {}

    public abstract void onSuccess(Response<T> response);

    public abstract void errorMsg(String msg);
}
