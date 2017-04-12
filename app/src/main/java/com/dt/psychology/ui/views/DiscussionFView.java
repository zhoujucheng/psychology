package com.dt.psychology.ui.views;

import com.dt.psychology.domain.Question;

import java.util.List;

/**
 * Created by dnnt9 on 2017/4/5.
 */

public interface DiscussionFView extends BaseView{
    void cancelRefresh();
    void setFooterStatus(int status);
    void addQuestionsAfterTail(List<Question> questions);
    void addQuestionsBeforeHead(List<Question> questions);
}
