package com.dt.psychology.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 文章
 * @author huangting
 *
 */
@Entity
public class Article implements Serializable {
    /**
     * 文章id号
     */
    @Id
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章图片的url
     */
    private String imagesUrl;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 浏览量
     */
    private Integer lookNums;

    /**
     * 感谢量
     */
    private Integer thanksNums;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 文章内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    @Generated(hash = 1782071150)
    public Article(Long id, String title, String imagesUrl, String author,
            Integer lookNums, Integer thanksNums, Date publishTime,
            String content) {
        this.id = id;
        this.title = title;
        this.imagesUrl = imagesUrl;
        this.author = author;
        this.lookNums = lookNums;
        this.thanksNums = thanksNums;
        this.publishTime = publishTime;
        this.content = content;
    }

    @Generated(hash = 742516792)
    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getLookNums() {
        return lookNums;
    }

    public void setLookNums(Integer lookNums) {
        this.lookNums = lookNums;
    }

    public Integer getThanksNums() {
        return thanksNums;
    }

    public void setThanksNums(Integer thanksNums) {
        this.thanksNums = thanksNums;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}