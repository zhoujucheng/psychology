package com.dt.psychology.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.io.Serializable;
import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * @author 
 */
public class QuestionTag implements Serializable {
    private static final long serialVersionUID = -5721449069327893899L;
    /**
     * 问题标签id
     */

    private Long questionTagId;

    /**
     * 标签名字
     */
    private String questionTagName;

    public QuestionTag() {
    }

    public Long getQuestionTagId() {
        return questionTagId;
    }

    public void setQuestionTagId(Long questionTagId) {
        this.questionTagId = questionTagId;
    }

    public String getQuestionTagName() {
        return questionTagName;
    }

    public void setQuestionTagName(String questionTagName) {
        this.questionTagName = questionTagName;
    }
}