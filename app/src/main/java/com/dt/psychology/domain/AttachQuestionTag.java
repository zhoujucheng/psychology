package com.dt.psychology.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author 
 */
@Entity
public class AttachQuestionTag implements Serializable {

    @Id
    private Long id;

    /**
     * 问题id
     */
    private Long questionId;

    /**
     * 问题标签id
     */
    private long questionTagId;

    private static final long serialVersionUID = 1L;

    @Generated(hash = 1998382669)
    public AttachQuestionTag(Long id, Long questionId, long questionTagId) {
        this.id = id;
        this.questionId = questionId;
        this.questionTagId = questionTagId;
    }

    @Generated(hash = 2116607867)
    public AttachQuestionTag() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}