package com.dt.psychology.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class AttachQuestionTag implements Serializable {
    /**
     * 问题id
     */
    private Long questionId;

    /**
     * 问题标签id
     */
    private Integer questionTagId;

    private static final long serialVersionUID = 1L;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionTagId() {
        return questionTagId;
    }

    public void setQuestionTagId(Integer questionTagId) {
        this.questionTagId = questionTagId;
    }
}