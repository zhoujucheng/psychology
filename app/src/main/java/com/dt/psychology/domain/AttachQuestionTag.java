package com.dt.psychology.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author 
 */
public class AttachQuestionTag implements Serializable {

    private static final long serialVersionUID = 4537952872373166320L;

    private Long id;

    /**
     * 问题id
     */
    private Long questionId;

    /**
     * 问题标签id
     */
    private long questionTagId;

    public AttachQuestionTag() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public long getQuestionTagId() {
        return questionTagId;
    }

    public void setQuestionTagId(long questionTagId) {
        this.questionTagId = questionTagId;
    }
}