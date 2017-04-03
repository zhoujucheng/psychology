package com.dt.psychology.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Question implements Serializable {
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
    private Long userId;

    /**
     * 对问题的描述
     */
    private String content;

    private static final long serialVersionUID = 1L;

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
}