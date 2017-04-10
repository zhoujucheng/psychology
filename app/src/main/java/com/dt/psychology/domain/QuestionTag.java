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
@Entity
public class QuestionTag implements Serializable {
    private static final long serialVersionUID = -5721449069327893899L;
    /**
     * 问题标签id
     */
    @Id
    private Long questionTagId;

    /**
     * 标签名字
     */
    private String questionTagName;

    @ToMany
    @JoinEntity(
            entity = AttachQuestionTag.class,
            sourceProperty = "questionTagId",
            targetProperty = "questionId")
    private List<AttachQuestionTag> attachQuestionTags;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1090097465)
    private transient QuestionTagDao myDao;


    public QuestionTag() {
    }

    @Generated(hash = 1746975836)
    public QuestionTag(Long questionTagId, String questionTagName) {
        this.questionTagId = questionTagId;
        this.questionTagName = questionTagName;
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

    public void setAttachQuestionTags(List<AttachQuestionTag> attachQuestionTags) {
        this.attachQuestionTags = attachQuestionTags;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 201110573)
    public List<AttachQuestionTag> getAttachQuestionTags() {
        if (attachQuestionTags == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AttachQuestionTagDao targetDao = daoSession.getAttachQuestionTagDao();
            List<AttachQuestionTag> attachQuestionTagsNew = targetDao
                    ._queryQuestionTag_AttachQuestionTags(questionTagId);
            synchronized (this) {
                if (attachQuestionTags == null) {
                    attachQuestionTags = attachQuestionTagsNew;
                }
            }
        }
        return attachQuestionTags;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 375486844)
    public synchronized void resetAttachQuestionTags() {
        attachQuestionTags = null;
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
    @Generated(hash = 788672931)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getQuestionTagDao() : null;
    }
}