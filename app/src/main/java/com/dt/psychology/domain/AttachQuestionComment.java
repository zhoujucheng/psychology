package com.dt.psychology.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class AttachQuestionComment implements Serializable {
    /**
     * 问题id号
     */
    private Long questionId;

    /**
     * 问题评论id号
     */
    private Long questionCommentId;

    private static final long serialVersionUID = 1L;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getQuestionCommentId() {
        return questionCommentId;
    }

    public void setQuestionCommentId(Long questionCommentId) {
        this.questionCommentId = questionCommentId;
    }
}