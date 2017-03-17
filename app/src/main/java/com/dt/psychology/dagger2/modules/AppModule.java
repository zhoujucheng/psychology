package com.dt.psychology.dagger2.modules;

import com.dt.psychology.test.Sevice;
import com.dt.psychology.ui.MyApplication;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
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
    Retrofit provideRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.BASE_URL)
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
