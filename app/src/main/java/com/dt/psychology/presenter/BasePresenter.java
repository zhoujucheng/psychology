package com.dt.psychology.presenter;

import com.dt.psychology.ui.views.BaseView;

/**
 * Created by dnnt9 on 2017/3/21.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
}
