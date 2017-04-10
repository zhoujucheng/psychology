package com.dt.psychology.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.DaoException;

/**
 * @author 
 */
@Entity
public class ArticleTag implements Serializable {
    private static final long serialVersionUID = 4292038257143417355L;
    /**
     * 文章标签id
     */
    @Id
    private Long articleTagId;

    /**
     * 标签的父级id
     */
    private Integer fatherId;

    /**
     * 文章标签名字
     */
    private String articleTagName;

    @ToMany
    @JoinEntity(
            entity = AttachArticleTag.class,
            sourceProperty = "articleTagId",
            targetProperty = "articleId"
    )
    private List<AttachArticleTag> attachArticleTags;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1656684347)
    private transient ArticleTagDao myDao;

    public ArticleTag() {
    }

    @Generated(hash = 853253321)
    public ArticleTag(Long articleTagId, Integer fatherId, String articleTagName) {
        this.articleTagId = articleTagId;
        this.fatherId = fatherId;
        this.articleTagName = articleTagName;
    }

    public Long getArticleTagId() {
        return articleTagId;
    }

    public void setArticleTagId(Long articleTagId) {
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

    public void setAttachArticleTags(List<AttachArticleTag> attachArticleTags) {
        this.attachArticleTags = attachArticleTags;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 259670672)
    public List<AttachArticleTag> getAttachArticleTags() {
        if (attachArticleTags == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AttachArticleTagDao targetDao = daoSession.getAttachArticleTagDao();
            List<AttachArticleTag> attachArticleTagsNew = targetDao
                    ._queryArticleTag_AttachArticleTags(articleTagId);
            synchronized (this) {
                if (attachArticleTags == null) {
                    attachArticleTags = attachArticleTagsNew;
                }
            }
        }
        return attachArticleTags;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1400166079)
    public synchronized void resetAttachArticleTags() {
        attachArticleTags = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 386513434)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getArticleTagDao() : null;
    }
}