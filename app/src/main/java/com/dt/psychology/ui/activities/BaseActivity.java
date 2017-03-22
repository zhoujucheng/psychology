package com.dt.psychology.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.dagger2.modules.ActivityModule;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.views.BaseView;
import com.dt.psychology.util.ToastUtil;

import butterknife.ButterKnife;

/**
 * Created by dnnt9 on 2017/3/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        inject(getActivityComponent());
        init();
    }

    public ActivityComponent getActivityComponent(){
        if (mActivityComponent == null){
            mActivityComponent = ((MyApplication)getApplication()).getAppComponent().plus(new ActivityModule());
        }
        return mActivityComponent;
    }

    @Override
    public void showToast(String text) {
        ToastUtil.showToast(this,text);
    }

    public void startActivity(Class<?> cls){
        startActivity(new Intent(this,cls));
    }

    protected abstract void init();

    protected abstract void inject(ActivityComponent activityComponent);

    protected abstract int getContentView();
}
