package com.dt.psychology.presenter.activitis;

import com.dt.psychology.ui.views.AskQuestionView;

import javax.inject.Inject;

/**
 * Created by dnnt9 on 2017/4/14.
 */

public class AskQuestionPresenterImpl implements AskQuestionPresenter {

    private AskQuestionView askQuestionView;

    @Inject
    AskQuestionPresenterImpl(){}

    @Override
    public void attachView(AskQuestionView view) {
        askQuestionView = view;
    }
}
