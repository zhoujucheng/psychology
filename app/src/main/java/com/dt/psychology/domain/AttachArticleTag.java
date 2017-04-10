package com.dt.psychology.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.internal.LongHashMap;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author 
 */
@Entity
public class AttachArticleTag implements Serializable {

    @Id(autoincrement = true)
    private Long id;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 文章标签id
     */
    private long articleTagId;

    private static final long serialVersionUID = 1L;


    public AttachArticleTag() {
    }

    @Generated(hash = 1652839592)
    public AttachArticleTag(Long id, Long articleId, long articleTagId) {
        this.id = id;
        this.articleId = articleId;
        this.articleTagId = articleTagId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public long getArticleTagId() {
        return articleTagId;
    }

    public void setArticleTagId(long articleTagId) {
        this.articleTagId = articleTagId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}