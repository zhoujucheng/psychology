package com.dt.psychology.ui;

import android.app.Application;

import com.dt.psychology.dagger2.components.AppComponent;
import com.dt.psychology.dagger2.components.DaggerAppComponent;
import com.dt.psychology.dagger2.modules.AppModule;

/**
 * Created by dnnt9 on 2017/3/17.
 */

public class MyApplication extends Application {

    public static final String BASE_URL = "http://192.168.199.226:8080/info/";

    private AppComponent appComponent;

    public AppComponent getAppComponent(){
        if (appComponent == null){
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        }
        return appComponent;
    }

}
