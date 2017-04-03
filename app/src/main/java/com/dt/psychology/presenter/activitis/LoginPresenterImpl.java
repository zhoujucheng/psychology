package com.dt.psychology.presenter.activitis;

import com.dt.psychology.network.UserService;
import com.dt.psychology.presenter.BasePresenter;
import com.dt.psychology.test.User;
import com.dt.psychology.ui.activities.MainActivity;
import com.dt.psychology.ui.views.LoginView;
import com.dt.psychology.util.Validator;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
    public void login(String user, String password) {
        Map<String,String> map = new HashMap<>();
        if (Validator.isMobile(user)){
            map.put("userPhone",user);
        }else if (Validator.isEmail(user)){
            map.put("userMail",user);
        }else {
            loginView.showToast("用户名错误");
            return;
        }
        if (Validator.isPassword(password)) map.put("password",password);
        else {
            loginView.showToast("密码错误");
            return;
        }
        userService.login(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {}

                    @Override
                    public void onNext(User user) {
                        loginView.getMyApplication().setUser(user);
                        loginView.startActivity(MainActivity.class);
                        loginView.activityFinish();
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        loginView.showToast("网络出错");
                    }

                    @Override
                    public void onComplete() {}
                });

    }
}
