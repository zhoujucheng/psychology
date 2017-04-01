package com.dt.psychology.ui.activities;

import android.os.Handler;
import android.widget.Button;

import com.dt.psychology.R;
import com.dt.psychology.dagger2.components.ActivityComponent;

import butterknife.BindView;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity {

    @BindView(R.id.activity_sign_up_btn_validate_code)
    Button btnValidateCode;

    @Override
    protected void init() {

    }

    @Override
    protected void inject(ActivityComponent activityComponent) {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sign_up;
    }

    @OnClick(R.id.activity_sign_up_btn_validate_code)
    public void getValidateCodeClick(){
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
                    btnValidateCode.setText("获取验证码");
                }
            }
        };
        new Handler().post(runnable);
    }

}
