package com.longbow.user.dal.po;

import com.longbow.core.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser extends BaseEntity {
    @Id
    private Long uid;

    private String username;

    private String password;

    private String name;

    private String email;

    private String mobile;

    @Column(name = "last_modified_password")
    private Date lastModifiedPassword;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "last_login_id")
    private String lastLoginId;

    private Integer status;

    /**
     * @return uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return last_modified_password
     */
    public Date getLastModifiedPassword() {
        return lastModifiedPassword;
    }

    /**
     * @param lastModifiedPassword
     */
    public void setLastModifiedPassword(Date lastModifiedPassword) {
        this.lastModifiedPassword = lastModifiedPassword;
    }

    /**
     * @return last_login_time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return last_login_id
     */
    public String getLastLoginId() {
        return lastLoginId;
    }

    /**
     * @param lastLoginId
     */
    public void setLastLoginId(String lastLoginId) {
        this.lastLoginId = lastLoginId;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}