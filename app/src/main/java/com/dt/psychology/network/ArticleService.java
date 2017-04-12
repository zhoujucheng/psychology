package com.dt.psychology.network;

import com.dt.psychology.domain.Article;
import com.dt.psychology.domain.Json;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by dnnt9 on 2017/4/5.
 */

public interface ArticleService {
    @GET("article/getArticle")
//    @GET("test")
    Observable<Response<Json<List<Article>>>> getArticles(@QueryMap Map<String,String> map);
}
