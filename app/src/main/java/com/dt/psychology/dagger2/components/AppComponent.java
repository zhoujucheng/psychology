package com.dt.psychology.dagger2.components;

import com.dt.psychology.dagger2.modules.ActivityModule;
import com.dt.psychology.dagger2.modules.AppModule;
import com.dt.psychology.ui.MyApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by dnnt9 on 2017/3/17.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    ActivityComponent plus(ActivityModule activityModule);
    void inject(MyApplication myApplication);
}
