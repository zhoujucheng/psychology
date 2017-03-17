package com.dt.psychology.test;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by dnnt9 on 2017/3/17.
 */

public interface Sevice {

    @GET("getUser")
    Observable<User> call(@Query("id") int id);
}
