package com.dt.psychology.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class AttachArticleTag implements Serializable {
    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 文章标签id
     */
    private Integer articleTagId;

    private static final long serialVersionUID = 1L;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getArticleTagId() {
        return articleTagId;
    }

    public void setArticleTagId(Integer articleTagId) {
        this.articleTagId = articleTagId;
    }
}