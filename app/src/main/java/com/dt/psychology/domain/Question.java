package com.dt.psychology.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;

/**
 * @author 
 */
public class Question implements Serializable {

    private static final long serialVersionUID = -7193669611932255474L;

    /**
     * 提问id号
     */
    private Long questionId;

    /**
     * 提问的标题
     */
    private String title;

    /**
     * 问题发布的时间
     */
    private Date createTime;

    /**
     * 问题更新的时间
     */
    private Date updateTime;

    /**
     * 问题的点赞数
     */
    private Long likeCount;

    /**
     * 发布问题的用户id
     */
    private long userId;

    /**
     * 发布问题的用户
     */
    private User user;

    /**
     * 对问题的描述
     */
    private String content;

    List<QuestionTag> questionTags;

    private long aplyCount;

    public Question() {}

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<QuestionTag> getQuestionTags() {
        return questionTags;
    }

    public void setQuestionTags(List<QuestionTag> questionTags) {
        this.questionTags = questionTags;
    }

    public long getAplyCount() {
        return aplyCount;
    }

    public void setAplyCount(long aplyCount) {
        this.aplyCount = aplyCount;
    }
}