package com.dt.psychology.presenter.activitis;

import com.dt.psychology.ui.views.WriteCommentView;

import javax.inject.Inject;

/**
 * Created by dnnt9 on 2017/4/14.
 */

public class WriteCommentPresenterImpl implements WriteCommentPresenter {

    private WriteCommentView writeCommentView;

    @Inject
    WriteCommentPresenterImpl(){}

    @Override
    public void attachView(WriteCommentView view) {
        writeCommentView = view;
    }

    public void commit(){

    }

}
