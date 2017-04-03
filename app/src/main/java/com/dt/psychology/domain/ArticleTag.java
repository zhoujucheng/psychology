package com.dt.psychology.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class ArticleTag implements Serializable {
    /**
     * 文章标签id
     */
    private Integer articleTagId;

    /**
     * 标签的父级id
     */
    private Integer fatherId;

    /**
     * 文章标签名字
     */
    private String articleTagName;

    private static final long serialVersionUID = 1L;

    public Integer getArticleTagId() {
        return articleTagId;
    }

    public void setArticleTagId(Integer articleTagId) {
        this.articleTagId = articleTagId;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public String getArticleTagName() {
        return articleTagName;
    }

    public void setArticleTagName(String articleTagName) {
        this.articleTagName = articleTagName;
    }
}