package com.dt.psychology.presenter.fragments;

import com.dt.psychology.domain.Question;
import com.dt.psychology.presenter.BasePresenter;
import com.dt.psychology.ui.views.DiscussionFView;

import java.util.List;

/**
 * Created by dnnt9 on 2017/4/5.
 */

public interface DiscussionFPresenter extends BasePresenter<DiscussionFView> {
    void loadMore(List<Question> questions,String keyWords);
    void refresh(List<Question> questions,String keyWords);
    void init();
}
