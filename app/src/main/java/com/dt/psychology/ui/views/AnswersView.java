package com.dt.psychology.ui.views;

import com.dt.psychology.domain.Comment;

import java.util.List;

/**
 * Created by dnnt9 on 2017/4/14.
 */

public interface AnswersView extends BaseView {
    void setAdapterStatus(int status);
    void addCommentsAfterTail(List<Comment> comments);
}
