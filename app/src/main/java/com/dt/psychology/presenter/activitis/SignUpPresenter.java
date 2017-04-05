package com.dt.psychology.presenter.activitis;

import com.dt.psychology.presenter.BasePresenter;
import com.dt.psychology.ui.views.SignUpView;

/**
 * Created by dnnt9 on 2017/4/5.
 */

public interface SignUpPresenter extends BasePresenter<SignUpView>{
    void getVerificationCode(String phoneOrEmail);
    void signUp(String phoneOrEmail,String verificationCode,String nickName,String password);
}
