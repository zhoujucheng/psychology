package com.dt.psychology.dagger2.modules;

import android.support.annotation.NonNull;
import android.util.Log;

import com.dt.psychology.domain.DaoMaster;
import com.dt.psychology.domain.DaoSession;
import com.dt.psychology.network.UserService;
import com.dt.psychology.ui.MyApplication;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.greenrobot.greendao.database.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dnnt9 on 2017/3/17.
 */

@Module
public class AppModule {
    MyApplication mApplication;
    private List<Cookie> cookies = new ArrayList<>();

    public AppModule(MyApplication application){
        mApplication = application;
    }

    @Provides
    @Singleton
    MyApplication provideMyApplication(){
        return  mApplication;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .cookieJar(new CookieJar() {
                    @Override
                    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                        cookies.addAll(list);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                        return cookies;
                    }
                })
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        long t1 = System.nanoTime();
                        Log.i("HttpRequest",String.format("Sending request %s on %s%n%s",
                                request.url(), chain.connection(), request.headers()));
                        Response response = chain.proceed(request);
                        long t2 = System.nanoTime();
                        Log.i("HttpResponse",String.format("Received response for %s in %.1fms%n%s",
                                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
                        String content = response.body().string();
                        MediaType mediaType = response.body().contentType();
                        Log.i("response code",String.valueOf(response.code()));
                        Log.i("response body",content);
                        Log.i("response message",response.message());
                        return response.newBuilder()
                                .body(okhttp3.ResponseBody.create(mediaType, content))
                                .build();
//                        return response;
                    }
                })
                //超时时间为5秒
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(MyApplication.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ExecutorService provideExecutorService(){
        return Executors.newCachedThreadPool();
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mApplication,"accompany");
        Database db = helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        return daoSession;
    }

    @Provides
    @Singleton
    UserService provideUserService(Retrofit retrofit){
        return retrofit.create(UserService.class);
    }

}
