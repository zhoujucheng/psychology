package com.dt.psychology.ui.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.ActivityComponent;
import com.dt.psychology.presenter.activitis.SignUpPresenter;
import com.dt.psychology.ui.views.SignUpView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity implements SignUpView{

    @BindView(R.id.activity_sign_up_btn_verification_code)
    Button btnVerificationCode;
    @BindView(R.id.activity_sign_up_tiedt_phone_email)
    TextInputEditText tiedtPhoneEmail;
    @BindView(R.id.activity_sign_up_tiedt_verification_code)
    TextInputEditText tiedtVerificationCode;
    @BindView(R.id.activity_sign_up_tiedt_nickname)
    TextInputEditText tiedtNickname;
    @BindView(R.id.activity_sign_up_tiedt_password)
    TextInputEditText tiedtPassword;
    @Inject
    SignUpPresenter signUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {
        signUpPresenter.attachView(this);
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sign_up;
    }

    @OnClick(R.id.activity_sign_up_btn_verification_code)
    public void getVerificationCodeClick(final View view){
        if (!view.isClickable())    return;
        view.setClickable(false);
        signUpPresenter.getVerificationCode(tiedtPhoneEmail.getText().toString());
        view.setBackgroundColor(ContextCompat.getColor(this,R.color.rippleDefaultColor));
        Runnable runnable = new Runnable() {
            private int countDown = 60;
            @Override
            public void run() {
                if (isFinishing())  return;
                if (countDown > 0){
                    btnVerificationCode.setText(String.valueOf(countDown));
                    new Handler().postDelayed(this,1000);
                    countDown--;
                }else {
                    view.setClickable(true);
                    view.setBackgroundColor(ContextCompat.getColor(SignUpActivity.this,R.color.buttonBackground));
                    btnVerificationCode.setText("获取验证码");
                }
            }
        };
        new Handler().post(runnable);
    }

    @OnClick(R.id.activity_sign_up_btn_sign_up)
    public void signUpClick(){
        signUpPresenter.signUp(tiedtPhoneEmail.getText().toString(),tiedtVerificationCode.getText().toString(),
                tiedtNickname.getText().toString(),tiedtPassword.getText().toString());
    }

    @OnClick(R.id.activity_sign_up_back)
    public void backClick(){
        onBackPressed();
    }

}
