package com.dt.psychology.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class QuestionImagesUrl implements Serializable {
    /**
     * 问题id
     */
    private Long questionId;

    /**
     * 图片的次序
     */
    private Byte order;

    /**
     * 图片的url
     */
    private String url;

    private static final long serialVersionUID = 1L;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Byte getOrder() {
        return order;
    }

    public void setOrder(Byte order) {
        this.order = order;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}