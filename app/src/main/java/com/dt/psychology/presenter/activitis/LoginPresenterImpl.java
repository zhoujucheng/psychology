package com.dt.psychology.presenter.activitis;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;

import com.dt.psychology.R;
import com.dt.psychology.domain.Json;
import com.dt.psychology.domain.User;
import com.dt.psychology.network.UserService;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.activities.MainActivity;
import com.dt.psychology.ui.views.LoginView;
import com.dt.psychology.util.Constant;
import com.dt.psychology.util.MyObserver;
import com.dt.psychology.util.NetworkUtil;
import com.dt.psychology.util.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by dnnt9 on 2017/4/2.
 */

public class LoginPresenterImpl implements LoginPresenter{

    private LoginView loginView;

    @Inject
    UserService userService;

    @Inject
    LoginPresenterImpl(){}

    @Override
    public void attachView(LoginView view) {
        loginView = view;
    }

    @Override
    public void login(String phoneOrEmail, String password) {
        //判断
        if (!NetworkUtil.isNetworkConnected(loginView.getMyApplication())) {
            loginView.showToast(R.string.network_unavailable);
        }else if (!Validator.isMobile(phoneOrEmail) && !Validator.isEmail(phoneOrEmail)){
            loginView.showToast("手机或邮箱错误");
        }else if (!Validator.isPassword(password)){
            loginView.showToast("密码错误");
        }else {
            final Map<String, String> map = new HashMap<>();
            if (Validator.isMobile(phoneOrEmail)){
                map.put("userPhone", phoneOrEmail);
            } else{
                map.put("userMail", phoneOrEmail);
            }
            map.put("password",password);
            final AlertDialog alertDialog = loginView.showDialogWithBar("正在登录..");
            userService.login(map)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new MyObserver<Json<User>>() {
                        @Override
                        public void onSuccess(Response<Json<User>> response) {
                            final User user = response.body().getObject();
                            MyApplication myApplication = loginView.getMyApplication();
                            myApplication.setUser(user);
                            alertDialog.dismiss();
                            ExecutorService es = myApplication.getExecutorService();
                            loginView.startActivity(MainActivity.class);
                            loginView.activityFinish();
                            //保存用户信息
                            es.submit(new Runnable() {
                                @Override
                                public void run() {
                                    Context context = loginView.getContext();
                                    SharedPreferences preferences = context.getSharedPreferences(Constant.SHARED_PRE_FILE_NAME, Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = preferences.edit();
                                    if (user.getUserPhone() != null && !user.getUserPhone().equals(""))
                                        editor.putLong(Constant.USER_NAME, user.getUserPhone());
                                    else if (user.getUserMail() != null && !user.getUserMail().equals(""))
                                        editor.putString(Constant.USER_NAME, user.getUserMail());
                                    editor.putString(Constant.USER_PASSWORD, user.getUserMail());
                                    editor.apply();
                                }
                            });
                        }
                        @Override
                        public void errorMsg(String msg) {
                            alertDialog.dismiss();
                            loginView.showDialog("登录失败",msg);
                        }
                    });
        }

    }

}
