package com.dt.psychology.ui;

import android.app.Application;
import android.telephony.TelephonyManager;

import com.dt.psychology.dagger2.components.AppComponent;
import com.dt.psychology.dagger2.components.DaggerAppComponent;
import com.dt.psychology.dagger2.modules.AppModule;
import com.dt.psychology.domain.DaoSession;
import com.dt.psychology.test.User;
import com.dt.psychology.ui.activities.ArticleActivity;
import com.squareup.leakcanary.LeakCanary;

import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

/**
 * Created by dnnt9 on 2017/3/17.
 */

public class MyApplication extends Application {

    public static final String BASE_URL = "http://192.168.199.226:8080/info/";
    private AppComponent appComponent;
    private User user;
    private static boolean networkUsable;
    @Inject
    ExecutorService executorService;
    @Inject
    DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
        if (LeakCanary.isInAnalyzerProcess(this)) return;
        LeakCanary.install(this);
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(User user){
        return user;
    }

    public ExecutorService getExecutorService(){
        return executorService;
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }

    public static boolean isNetworkUsable() {
        return networkUsable;
    }

    public static void setNetworkUsable(boolean networkUsable) {
        MyApplication.networkUsable = networkUsable;
    }
}
