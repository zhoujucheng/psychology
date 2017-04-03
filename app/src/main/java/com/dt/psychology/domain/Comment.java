package com.dt.psychology.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Comment implements Serializable {
    /**
     * 问题评论id
     */
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

    /**
     * 评论的内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

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
}