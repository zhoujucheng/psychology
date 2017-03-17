package com.dt.psychology.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.dagger2.components.AppComponent;
import com.dt.psychology.dagger2.modules.ActivityModule;
import com.dt.psychology.dagger2.modules.AppModule;
import com.dt.psychology.ui.MyApplication;

import butterknife.ButterKnife;

/**
 * Created by dnnt9 on 2017/3/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        Thread.setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
        ButterKnife.bind(this);
        inject(getActivityComponent());
        init();
    }

    protected ActivityComponent getActivityComponent(){
        if (mActivityComponent == null){
            mActivityComponent = ((MyApplication)getApplication()).getAppComponent().plus(new ActivityModule());
        }
        return mActivityComponent;
    }

    protected abstract void init();

    protected abstract void inject(ActivityComponent activityComponent);

    protected abstract int getContentView();
}
