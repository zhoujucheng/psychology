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
import com.dt.psychology.util.MyFunction;
import com.dt.psychology.util.MyObserver;
import com.dt.psychology.util.NetworkUtil;
import com.dt.psychology.util.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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
        if (!MyApplication.isNetworkUsable()) {
            loginView.showToast(R.string.network_unavailable);
        }else if (!Validator.isMobile(phoneOrEmail) && !Validator.isEmail(phoneOrEmail)){
            loginView.showToast("手机/邮箱错误");
        }else if (!Validator.isPassword(password)){
            loginView.showToast("密码错误");
        }else {
            final Map<String, String> map = new HashMap<>();
            if (Validator.isMobile(phoneOrEmail)){
                map.put(Constant.USER_PHONE, phoneOrEmail);
            } else{
                map.put(Constant.USER_EMAIL, phoneOrEmail);
            }
            map.put(Constant.USER_PASSWORD,password);
            userService.login(map)
                    .subscribeOn(Schedulers.io())
//                    .observeOn(Schedulers.io())
//                    .map(new MyFunction<Json<User>>())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .doOnNext(new Consumer<Json<User>>() {
//                        @Override
//                        public void accept(Json<User> userJson) throws Exception {
//
//                        }
//                    })
//                    .observeOn(Schedulers.io())
//                    .doOnNext(new Consumer<Json<User>>() {
//                        @Override
//                        public void accept(Json<User> userJson) throws Exception {
//
//                        }
//                    })
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Observer<Json<User>>() {
//                        @Override
//                        public void onSubscribe(Disposable d) {
//
//                        }
//
//                        @Override
//                        public void onNext(Json<User> value) {
//
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//
//                        }
//
//                        @Override
//                        public void onComplete() {
//
//                        }
//                    });
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new MyObserver<Json<User>>() {
                        private AlertDialog alertDialog;
                        @Override
                        public void onSubscribe(Disposable disposable) {
                            alertDialog = loginView.showDialogWithBar("正在登录..");
                        }
                        @Override
                        public void onSuccess(Json<User> json) {
                            final User user = json.getObject();
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
                                        editor.putString(Constant.USER_PHONE_EMAIL, String.valueOf(user.getUserPhone()));
                                    else if (user.getUserMail() != null && !user.getUserMail().equals(""))
                                        editor.putString(Constant.USER_PHONE_EMAIL, user.getUserMail());
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
