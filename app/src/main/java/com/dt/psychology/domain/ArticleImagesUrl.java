package com.dt.psychology.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class ArticleImagesUrl implements Serializable {
    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 图片的次序
     */
    private Byte order;

    /**
     * 图片的url
     */
    private String url;

    private static final long serialVersionUID = 1L;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
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