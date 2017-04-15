package com.dt.psychology.network;

import com.dt.psychology.domain.Comment;
import com.dt.psychology.domain.Json;
import com.dt.psychology.domain.Question;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by dnnt9 on 2017/4/11.
 */

public interface QAndAService {
    @GET("question/queryQuestions")
    Observable<Response<Json<List<Question>>>>  getQuestions(@QueryMap Map<String,String> map);

    @GET("abc")
    Observable<Response<Json<List<Comment>>>> getComments(@QueryMap Map<String,Long> map);

    @GET("abc")
    Observable<Response<Json<List<Question>>>> getMyQuestions(@QueryMap Map<String,String> map);

    @GET("aabc")
    Observable<Response<Json<List<Comment>>>> getMyComments(@QueryMap Map<String,String> map);
}
