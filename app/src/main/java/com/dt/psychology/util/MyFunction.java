package com.dt.psychology.util;

import com.dt.psychology.domain.Json;

import io.reactivex.functions.Function;
import retrofit2.Response;

/**
 * Created by dnnt9 on 2017/4/8.
 */

public class MyFunction<R extends Json> implements Function<Response<R>,R> {
    @Override
    public R apply(Response<R> rResponse) throws Exception {
            if (rResponse.isSuccessful()){
            R rJson = rResponse.body();
            if (rJson.isSuccessful())   return rJson;
            else throw new OperationFailureException(rJson.getMessage());
        }else throw new ServerException();
    }
//    @Override
//    public R apply(T response) throws Exception {

//    }
}
