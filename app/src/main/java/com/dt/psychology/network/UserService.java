package com.dt.psychology.network;

import com.dt.psychology.test.User;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by dnnt9 on 2017/4/2.
 */

public interface UserService {
    @FormUrlEncoded
    @POST("user/login")
    Observable<User> login(@FieldMap Map<String,String> map);
}
