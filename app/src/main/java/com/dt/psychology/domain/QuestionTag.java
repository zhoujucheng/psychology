package com.dt.psychology.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class QuestionTag implements Serializable {
    /**
     * 问题标签id
     */
    private Integer questionTagId;

    /**
     * 标签名字
     */
    private String questionTagName;

    private static final long serialVersionUID = 1L;

    public Integer getQuestionTagId() {
        return questionTagId;
    }

    public void setQuestionTagId(Integer questionTagId) {
        this.questionTagId = questionTagId;
    }

    public String getQuestionTagName() {
        return questionTagName;
    }

    public void setQuestionTagName(String questionTagName) {
        this.questionTagName = questionTagName;
    }
}