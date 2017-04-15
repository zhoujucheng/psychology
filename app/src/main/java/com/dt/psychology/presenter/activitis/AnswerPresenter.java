package com.dt.psychology.presenter.activitis;

import com.dt.psychology.presenter.BasePresenter;
import com.dt.psychology.ui.views.AnswersView;

/**
 * Created by dnnt9 on 2017/4/14.
 */

public interface AnswerPresenter extends BasePresenter<AnswersView>{
    void getAnswers(long questionId,long answerId);
}
