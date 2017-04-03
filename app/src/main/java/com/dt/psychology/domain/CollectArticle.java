package com.dt.psychology.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class CollectArticle implements Serializable {
    private Long userId;

    private Long articleId;

    /**
     * 文章收藏时间
     */
    private Date collectTime;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}