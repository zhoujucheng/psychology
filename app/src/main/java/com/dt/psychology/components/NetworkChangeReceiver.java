package com.dt.psychology.components;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.dt.psychology.domain.Json;
import com.dt.psychology.domain.User;
import com.dt.psychology.network.UserService;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.views.BaseView;
import com.dt.psychology.util.Constant;
import com.dt.psychology.util.MyObserver;
import com.dt.psychology.util.NetworkUtil;
import com.dt.psychology.util.Validator;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Inject
    UserService userService;

    @Inject
    public NetworkChangeReceiver(){}

    @Override
    public void onReceive(final Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // 网络变化接收器
        Log.i("network","network change");
        if (NetworkUtil.isNetworkConnected(context)){
            MyApplication.setNetworkUsable(true);
            final MyApplication myApplication = (MyApplication) context.getApplicationContext();
            if (myApplication.getUser() != null)    return;
            SharedPreferences preferences = context.getSharedPreferences(Constant.SHARED_PRE_FILE_NAME,Context.MODE_PRIVATE);
            String phoneOrEmail = preferences.getString(Constant.USER_PHONE_EMAIL,"");
            if (phoneOrEmail.equals(""))    return;
            Map<String , String> map = new HashMap<>();
            if (Validator.isMobile(phoneOrEmail)){
                map.put(Constant.USER_PHONE,phoneOrEmail);
            }else {
                map.put(Constant.USER_EMAIL,phoneOrEmail);
            }
            String password = preferences.getString(Constant.USER_PASSWORD,"");
            map.put(Constant.USER_PASSWORD,password);
            userService.login(map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new MyObserver<Json<User>>() {
                        @Override
                        public void onSuccess(Json<User> json) {
                            myApplication.setUser(json.getObject());
                        }
                        @Override
                        public void errorMsg(String msg) {
                            BaseView baseView = (BaseView)context;
                            baseView.showToast(msg);
                        }
                    });
        }else{
            MyApplication.setNetworkUsable(false);
        }
    }
}
