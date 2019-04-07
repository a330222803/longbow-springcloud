package com.longbow.user.dal.po;

import com.longbow.core.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_session")
public class SysSession extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sessionid;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "tenant_code")
    private String tenantCode;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "expire_time")
    private Date expireTime;

    @Column(name = "refresh_time")
    private Date refreshTime;

    private String jwt;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return sessionid
     */
    public String getSessionid() {
        return sessionid;
    }

    /**
     * @param sessionid
     */
    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return tenant_code
     */
    public String getTenantCode() {
        return tenantCode;
    }

    /**
     * @param tenantCode
     */
    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return expire_time
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * @param expireTime
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * @return refresh_time
     */
    public Date getRefreshTime() {
        return refreshTime;
    }

    /**
     * @param refreshTime
     */
    public void setRefreshTime(Date refreshTime) {
        this.refreshTime = refreshTime;
    }

    /**
     * @return jwt
     */
    public String getJwt() {
        return jwt;
    }

    /**
     * @param jwt
     */
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}