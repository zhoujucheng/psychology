package com.dt.psychology.components;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.dt.psychology.network.UserService;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.util.NetworkUtil;

import javax.inject.Inject;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Inject
    UserService userService;

    @Inject
    public NetworkChangeReceiver(){}

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (NetworkUtil.isNetworkConnected(context.getApplicationContext())){
            MyApplication.setNetworkUsable(true);
            //          userService.login()
        }else{
            MyApplication.setNetworkUsable(false);
        }
    }
}
