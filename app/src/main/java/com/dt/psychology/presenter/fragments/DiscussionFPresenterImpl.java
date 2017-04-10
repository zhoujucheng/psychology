package com.dt.psychology.presenter.fragments;

import com.dt.psychology.ui.views.DiscussionFView;

import javax.inject.Inject;

/**
 * Created by dnnt9 on 2017/4/5.
 */

public class DiscussionFPresenterImpl implements DiscussionFPresenter {

    private DiscussionFView discussionFView;

    @Inject
    DiscussionFPresenterImpl(){}

    @Override
    public void attachView(DiscussionFView view) {
        discussionFView = view;
    }

    public void init(){

    }

    public void loadMore(){

    }

    public void reflesh(){}
}
