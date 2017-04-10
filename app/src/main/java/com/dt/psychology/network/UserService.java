package com.dt.psychology.network;

import com.dt.psychology.domain.Json;
import com.dt.psychology.domain.User;

import java.util.Map;

import javax.inject.Qualifier;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by dnnt9 on 2017/4/2.
 */

public interface UserService {
    @FormUrlEncoded
    @POST("user/login")
    Observable<Response<Json<User>>> login(@FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("user/QRCode")
    Observable<Response<Json>> getVerificationCode(@FieldMap Map<String,String> map);

    @FormUrlEncoded
    @POST("user/register")
    Observable<Response<Json<User>>> signUp(@FieldMap Map<String,String> map);
}
