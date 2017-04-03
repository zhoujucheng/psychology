package com.dt.psychology.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class AttachArticleComment implements Serializable {
    /**
     * 文章id号
     */
    private Long articleId;

    /**
     * 文章评论id号
     */
    private Long articleCommentId;

    private static final long serialVersionUID = 1L;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getArticleCommentId() {
        return articleCommentId;
    }

    public void setArticleCommentId(Long articleCommentId) {
        this.articleCommentId = articleCommentId;
    }
}