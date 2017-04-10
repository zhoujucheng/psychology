package com.dt.psychology.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.util.Constant;
import com.dt.psychology.util.NetworkUtil;

public class SplashActivity extends BaseActivity {

    @Override
    public void init(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences(Constant.SHARED_PRE_FILE_NAME,MODE_PRIVATE);
                String phoneOrEmail = preferences.getString(Constant.USER_PHONE_EMAIL,"");
                if (phoneOrEmail.equals("")){
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                }else {
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }
                finish();
            }
        }, 1000);
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_spash;
    }
}
