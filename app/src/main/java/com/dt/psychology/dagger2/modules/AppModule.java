package com.dt.psychology.dagger2.modules;

import android.util.Log;

import com.dt.psychology.test.Sevice;
import com.dt.psychology.ui.MyApplication;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
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

    public AppModule(MyApplication application){
        mApplication = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplication(){
        return  mApplication;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
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
                        return response;
                    }
                })
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    Sevice provideSevice(Retrofit retrofit){
        return retrofit.create(Sevice.class);
    }


}
