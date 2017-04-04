package com.dt.psychology.ui.activities;

import android.content.IntentFilter;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dt.psychology.R;
import com.dt.psychology.components.NetworkChangeReceiver;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.presenter.activitis.LoginPresenter;
import com.dt.psychology.ui.views.LoginView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView{

    @BindView(R.id.activity_login_tiedt_phone_email)
    TextInputEditText tiedtPhoneEmail;
    @BindView(R.id.activity_login_tiedt_password)
    TextInputEditText tiedtPassword;
    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void init() {
        loginPresenter.attachView(this);
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.activity_login_tv_look_around)
    public void lookAroundClick(){
        startActivity(MainActivity.class);
    }

    @OnClick(R.id.activity_login_tv_sign_up)
    public void signUpClick(){
        startActivity(SignUpActivity.class);
    }

    @OnClick(R.id.activity_login_btn_login)
    public void loginClick(){
        loginPresenter.login(tiedtPhoneEmail.getText().toString(),tiedtPassword.getText().toString());
    }
}
