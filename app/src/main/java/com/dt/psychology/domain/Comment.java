package com.dt.psychology.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import java.io.Serializable;
import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * @author 
 */
@Entity
public class Comment implements Serializable {
    /**
     * 问题评论id
     */
    @Id
    private Long commentId;

    /**
     * 父级评论的id号
     */
    private Long fatherId;
 /**
     * 评论的类别,0是文章评论;1是问题评论
     */
    private Byte commentCategory;

    /**
     * 发布评论的时间
     */
    private Date createTime;

    /**
     * 评论的用户的id号
     */
    private Long userId;

    @ToOne(joinProperty = "userId")
    private User user;

    /**
     * 评论的内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1903578761)
    private transient CommentDao myDao;

    @Generated(hash = 1455888385)
    public Comment(Long commentId, Long fatherId, Byte commentCategory,
            Date createTime, Long userId, String content) {
        this.commentId = commentId;
        this.fatherId = fatherId;
        this.commentCategory = commentCategory;
        this.createTime = createTime;
        this.userId = userId;
        this.content = content;
    }

    @Generated(hash = 1669165771)
    public Comment() {
    }

    @Generated(hash = 251390918)
    private transient Long user__resolvedKey;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getFatherId() {
        return fatherId;
    }

    public void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
    }

    public Byte getCommentCategory() {
        return commentCategory;
    }

    public void setCommentCategory(Byte commentCategory) {
        this.commentCategory = commentCategory;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getCurUser(){
        if (user == null)   return getUser();
        return user;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 859885876)
    public User getUser() {
        Long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1065606912)
    public void setUser(User user) {
        synchronized (this) {
            this.user = user;
            userId = user == null ? null : user.getId();
            user__resolvedKey = userId;
        }
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
    @Generated(hash = 2038262053)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCommentDao() : null;
    }
}