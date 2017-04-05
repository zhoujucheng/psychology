package com.dt.psychology.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author 
 */
@Entity
public class User implements Serializable {
    /**
     * 用户id号
     */
    @Id
    private Long id;

    /**
     * 用户头像图片保存的路径
     */
    private String headPortraitSrc;

    /**
     * 用户手机号
     */
    private Long userPhone;

    /**
     * 用户邮箱
     */
    private String userMail;

    /**
     * 用户昵称
     */
    private String alias;

    /**
     * 用户性别：0表示男，1表示女
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地区
     */
    private String area;

    /**
     * 用户简介
     */
    private String briefing;

    private String password;

    private static final long serialVersionUID = 1L;

    public User() {
    }

    @Generated(hash = 829957669)
    public User(Long id, String headPortraitSrc, Long userPhone, String userMail,
            String alias, String sex, Integer age, String area, String briefing,
            String password) {
        this.id = id;
        this.headPortraitSrc = headPortraitSrc;
        this.userPhone = userPhone;
        this.userMail = userMail;
        this.alias = alias;
        this.sex = sex;
        this.age = age;
        this.area = area;
        this.briefing = briefing;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadPortraitSrc() {
        return headPortraitSrc;
    }

    public void setHeadPortraitSrc(String headPortraitSrc) {
        this.headPortraitSrc = headPortraitSrc;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBriefing() {
        return briefing;
    }

    public void setBriefing(String briefing) {
        this.briefing = briefing;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}