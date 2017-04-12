package com.dt.psychology.network;

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
    @GET("abc")
    Observable<Response<Json<List<Question>>>>  getQuestins(@QueryMap Map<String,String> map);
}
