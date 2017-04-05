package com.dt.psychology.presenter.activitis;

import com.dt.psychology.presenter.BasePresenter;
import com.dt.psychology.ui.views.LoginView;

/**
 * Created by dnnt9 on 2017/4/2.
 */

public interface LoginPresenter extends BasePresenter<LoginView>{
    void login(String phoneOrEmail,String password);
}
