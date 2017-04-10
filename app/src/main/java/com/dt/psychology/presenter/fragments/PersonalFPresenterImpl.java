package com.dt.psychology.presenter.fragments;

import com.dt.psychology.ui.views.PersonalFView;

import javax.inject.Inject;

/**
 * Created by dnnt9 on 2017/4/5.
 */

public class PersonalFPresenterImpl implements PersonalFPresenter {

    private PersonalFView personalFView;

    @Inject
    PersonalFPresenterImpl(){}

    @Override
    public void attachView(PersonalFView view) {
        personalFView = view;
    }
}
