package com.dt.psychology.ui.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.ActivityComponent;

import butterknife.BindView;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity {

    @BindView(R.id.activity_sign_up_btn_validate_code)
    Button btnValidateCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void init() {}

    @Override
    protected void inject(ActivityComponent activityComponent) {}

    @Override
    protected int getContentView() {
        return R.layout.activity_sign_up;
    }

    @OnClick(R.id.activity_sign_up_btn_validate_code)
    public void getValidateCodeClick(final View view){
        if (!view.isClickable())    return;
        view.setClickable(false);
        view.setBackgroundColor(ContextCompat.getColor(this,R.color.rippleDefaultColor));
        Runnable runnable = new Runnable() {
            private int countDown = 60;
            @Override
            public void run() {
                if (isFinishing())  return;
                if (countDown > 0){
                    btnValidateCode.setText(String.valueOf(countDown));
                    new Handler().postDelayed(this,1000);
                    countDown--;
                }else {
                    view.setClickable(true);
                    view.setBackgroundColor(ContextCompat.getColor(SignUpActivity.this,R.color.buttonBackground));
                    btnValidateCode.setText("获取验证码");
                }
            }
        };
        new Handler().post(runnable);
    }

    @OnClick(R.id.activity_sign_up_back)
    public void backClick(){
        onBackPressed();
    }

}
