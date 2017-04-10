package com.dt.psychology.presenter.activitis;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import com.dt.psychology.R;
import com.dt.psychology.domain.Json;
import com.dt.psychology.domain.User;
import com.dt.psychology.network.UserService;
import com.dt.psychology.ui.MyApplication;
import com.dt.psychology.ui.views.SignUpView;
import com.dt.psychology.util.Constant;
import com.dt.psychology.util.MyObserver;
import com.dt.psychology.util.Validator;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by dnnt9 on 2017/4/5.
 */

public class SignUpPresenterImpl implements SignUpPresenter {

    private SignUpView signUpView;

    @Inject
    UserService userService;
    @Inject
    Context context;

    @Inject
    public SignUpPresenterImpl(){}

    @Override
    public void attachView(SignUpView view) {
        signUpView = view;
    }

    @Override
    public void getVerificationCode(String phoneOrEmail) {
        //在调用该方法之前已经验证过phoneOrEmail和网络状态
        Map<String,String> map = new HashMap<>();
        if (Validator.isMobile(phoneOrEmail)){
            map.put(Constant.USER_PHONE,phoneOrEmail);
        }else {
            map.put(Constant.USER_EMAIL, phoneOrEmail);
        }
        userService.getVerificationCode(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new MyObserver<Json>() {
                    @Override
                    public void onSuccess(Json json) {
                        signUpView.showToast(json.getMessage());
                    }

                    @Override
                    public void errorMsg(String msg) {
                        signUpView.showToast(msg);
                    }
                });
    }

    @Override
    public void signUp(String phoneOrEmail, String verificationCode, String nickName, String password) {
        if (!MyApplication.isNetworkUsable()){
            signUpView.showToast(R.string.network_unavailable);
        }else if (!Validator.isMobile(phoneOrEmail) && !Validator.isEmail(phoneOrEmail)){
            signUpView.showToast("手机或邮箱格式错误");
        }else if (!Validator.isVerificationCode(verificationCode)){
            signUpView.showToast("验证码错误");
        }else if (!Validator.isNickname(nickName)){
            signUpView.showToast("昵称格式错误");
        }else if (!Validator.isPassword(password)){
            signUpView.showToast("密码格式错误");
        }else {
            Map<String,String> map = new HashMap<>();
            if (Validator.isMobile(phoneOrEmail)){
                map.put(Constant.USER_PHONE,phoneOrEmail);
            }else if (Validator.isEmail(phoneOrEmail)){
                map.put(Constant.USER_EMAIL,phoneOrEmail);
            }
            map.put("verificationCode",verificationCode);
            map.put("alias",nickName);
            map.put(Constant.USER_PASSWORD,password);
            userService.signUp(map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new MyObserver<Json<User>>() {
                        private AlertDialog alertDialog;
                        @Override
                        public void onSubscribe(Disposable disposable) {
                            alertDialog = signUpView.showDialogWithBar("正在注册，请稍候...");
                        }

                        @Override
                        public void onSuccess(Json<User> json) {
                            alertDialog.dismiss();
                            signUpView.showDialog("注册成功","");
                        }
                        @Override
                        public void errorMsg(String msg) {
                            alertDialog.dismiss();
                            signUpView.showDialog("注册失败",msg);
                        }
                    });
        }
    }
}
