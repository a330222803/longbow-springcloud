package com.longbow.customer.dal.po;


import com.longbow.api.customer.domain.CustomerInfo;
import com.longbow.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_crm_special_resource_history")
public class CrmCustomerResourceHis extends BaseEntity<CustomerInfo> {
    @Id
    @Column(name = "sc_id")
    private Integer scId;

    /**
     * 姓名
     */
    @Column(name = "sc_name")
    private String scName;

    /**
     * 邮件地址
     */
    @Column(name = "sc_email")
    private String scEmail;

    @Column(name = "sc_phone")
    private String scPhone;

    @Column(name = "sc_phone_bak")
    private String scPhoneBak;

    /**
     * 座机
     */
    @Column(name = "sc_tel")
    private String scTel;

    /**
     * 联系地址
     */
    @Column(name = "sc_address")
    private String scAddress;

    /**
     * 省份
     */
    @Column(name = "sc_province")
    private String scProvince;

    /**
     * 提交时间
     */
    @Column(name = "dt_commit_time")
    private Date dtCommitTime;

    /**
     * 处理时间
     */
    @Column(name = "dt_handel_time")
    private Date dtHandelTime;

    /**
     * 备注信息
     */
    @Column(name = "sc_comments")
    private String scComments;

    /**
     * 性别
     */
    @Column(name = "sc_sex")
    private String scSex;

    /**
     * 活动ID
     */
    @Column(name = "sport_id")
    private Integer sportId;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 来源渠道
     */
    @Column(name = "sc_reffer")
    private String scReffer;

    /**
     * 活动名称
     */
    @Column(name = "sport_name")
    private String sportName;

    /**
     * 提取时间
     */
    @Column(name = "dt_fetch_time")
    private Date dtFetchTime;

    /**
     * 来源描述2
     */
    @Column(name = "sc_reffer2")
    private String scReffer2;

    /**
     * 来源描述3
     */
    @Column(name = "sc_reffer3")
    private String scReffer3;

    /**
     * 来源描述4
     */
    @Column(name = "sc_reffer4")
    private String scReffer4;

    /**
     * 来源ID
     */
    @Column(name = "ref_id")
    private Integer refId;

    /**
     * 处理状态：0：未分配；1-已自动分配；2-已手动分配； 3-分配到td系统;4-特殊活动不派发
     */
    @Column(name = "sc_status")
    private Byte scStatus;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "plugs_id")
    private Integer plugsId;

    @Column(name = "pro_id")
    private Integer proId;

    /**
     * 是否可以派发
     */
    private Boolean assignable;

    /**
     * 资源来源
     */
    @Column(name = "sc_source")
    private String scSource;

    @Column(name = "sc_platform")
    private String scPlatform;

    private String username;

    /**
     * 是否验证
     */
    @Column(name = "reply_status")
    private Byte replyStatus;

    /**
     * 资源类型(复苏资源)0、默认类型 2、复苏资源类型 3、12114资源类型
     */
    @Column(name = "resources_Type")
    private Byte resourcesType;

    /**
     * 客户唯一标示
     */
    @Column(name = "cus_unique_id")
    private String cusUniqueId;

    /**
     * 1、网聊资源2、网聊加入派工列表3、第三方资源
     */
    @Column(name = "netchat_res")
    private Byte netchatRes;

    /**
     * 加入者
     */
    @Column(name = "add_emp_id")
    private Integer addEmpId;

    /**
     * 是否新资源，0：否，1：是
     */
    @Column(name = "new_res")
    private Boolean newRes;

    /**
     * 来源渠道ID
     */
    @Column(name = "ytx_ref_id")
    private Integer ytxRefId;

    /**
     * 推广计划ID
     */
    @Column(name = "ytx_ref_id2")
    private Integer ytxRefId2;

    /**
     * 推广单元ID
     */
    @Column(name = "ytx_ref_id3")
    private Integer ytxRefId3;

    /**
     * 推广关键词ID
     */
    @Column(name = "ytx_ref_id4")
    private Integer ytxRefId4;

    /**
     * @return sc_id
     */
    public Integer getScId() {
        return scId;
    }

    /**
     * @param scId
     */
    public void setScId(Integer scId) {
        this.scId = scId;
    }

    /**
     * 获取姓名
     *
     * @return sc_name - 姓名
     */
    public String getScName() {
        return scName;
    }

    /**
     * 设置姓名
     *
     * @param scName 姓名
     */
    public void setScName(String scName) {
        this.scName = scName;
    }

    /**
     * 获取邮件地址
     *
     * @return sc_email - 邮件地址
     */
    public String getScEmail() {
        return scEmail;
    }

    /**
     * 设置邮件地址
     *
     * @param scEmail 邮件地址
     */
    public void setScEmail(String scEmail) {
        this.scEmail = scEmail;
    }

    /**
     * @return sc_phone
     */
    public String getScPhone() {
        return scPhone;
    }

    /**
     * @param scPhone
     */
    public void setScPhone(String scPhone) {
        this.scPhone = scPhone;
    }

    /**
     * @return sc_phone_bak
     */
    public String getScPhoneBak() {
        return scPhoneBak;
    }

    /**
     * @param scPhoneBak
     */
    public void setScPhoneBak(String scPhoneBak) {
        this.scPhoneBak = scPhoneBak;
    }

    /**
     * 获取座机
     *
     * @return sc_tel - 座机
     */
    public String getScTel() {
        return scTel;
    }

    /**
     * 设置座机
     *
     * @param scTel 座机
     */
    public void setScTel(String scTel) {
        this.scTel = scTel;
    }

    /**
     * 获取联系地址
     *
     * @return sc_address - 联系地址
     */
    public String getScAddress() {
        return scAddress;
    }

    /**
     * 设置联系地址
     *
     * @param scAddress 联系地址
     */
    public void setScAddress(String scAddress) {
        this.scAddress = scAddress;
    }

    /**
     * 获取省份
     *
     * @return sc_province - 省份
     */
    public String getScProvince() {
        return scProvince;
    }

    /**
     * 设置省份
     *
     * @param scProvince 省份
     */
    public void setScProvince(String scProvince) {
        this.scProvince = scProvince;
    }

    /**
     * 获取提交时间
     *
     * @return dt_commit_time - 提交时间
     */
    public Date getDtCommitTime() {
        return dtCommitTime;
    }

    /**
     * 设置提交时间
     *
     * @param dtCommitTime 提交时间
     */
    public void setDtCommitTime(Date dtCommitTime) {
        this.dtCommitTime = dtCommitTime;
    }

    /**
     * 获取处理时间
     *
     * @return dt_handel_time - 处理时间
     */
    public Date getDtHandelTime() {
        return dtHandelTime;
    }

    /**
     * 设置处理时间
     *
     * @param dtHandelTime 处理时间
     */
    public void setDtHandelTime(Date dtHandelTime) {
        this.dtHandelTime = dtHandelTime;
    }

    /**
     * 获取备注信息
     *
     * @return sc_comments - 备注信息
     */
    public String getScComments() {
        return scComments;
    }

    /**
     * 设置备注信息
     *
     * @param scComments 备注信息
     */
    public void setScComments(String scComments) {
        this.scComments = scComments;
    }

    /**
     * 获取性别
     *
     * @return sc_sex - 性别
     */
    public String getScSex() {
        return scSex;
    }

    /**
     * 设置性别
     *
     * @param scSex 性别
     */
    public void setScSex(String scSex) {
        this.scSex = scSex;
    }

    /**
     * 获取活动ID
     *
     * @return sport_id - 活动ID
     */
    public Integer getSportId() {
        return sportId;
    }

    /**
     * 设置活动ID
     *
     * @param sportId 活动ID
     */
    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    /**
     * 获取IP地址
     *
     * @return ip - IP地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置IP地址
     *
     * @param ip IP地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取来源渠道
     *
     * @return sc_reffer - 来源渠道
     */
    public String getScReffer() {
        return scReffer;
    }

    /**
     * 设置来源渠道
     *
     * @param scReffer 来源渠道
     */
    public void setScReffer(String scReffer) {
        this.scReffer = scReffer;
    }

    /**
     * 获取活动名称
     *
     * @return sport_name - 活动名称
     */
    public String getSportName() {
        return sportName;
    }

    /**
     * 设置活动名称
     *
     * @param sportName 活动名称
     */
    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    /**
     * 获取提取时间
     *
     * @return dt_fetch_time - 提取时间
     */
    public Date getDtFetchTime() {
        return dtFetchTime;
    }

    /**
     * 设置提取时间
     *
     * @param dtFetchTime 提取时间
     */
    public void setDtFetchTime(Date dtFetchTime) {
        this.dtFetchTime = dtFetchTime;
    }

    /**
     * 获取来源描述2
     *
     * @return sc_reffer2 - 来源描述2
     */
    public String getScReffer2() {
        return scReffer2;
    }

    /**
     * 设置来源描述2
     *
     * @param scReffer2 来源描述2
     */
    public void setScReffer2(String scReffer2) {
        this.scReffer2 = scReffer2;
    }

    /**
     * 获取来源描述3
     *
     * @return sc_reffer3 - 来源描述3
     */
    public String getScReffer3() {
        return scReffer3;
    }

    /**
     * 设置来源描述3
     *
     * @param scReffer3 来源描述3
     */
    public void setScReffer3(String scReffer3) {
        this.scReffer3 = scReffer3;
    }

    /**
     * 获取来源描述4
     *
     * @return sc_reffer4 - 来源描述4
     */
    public String getScReffer4() {
        return scReffer4;
    }

    /**
     * 设置来源描述4
     *
     * @param scReffer4 来源描述4
     */
    public void setScReffer4(String scReffer4) {
        this.scReffer4 = scReffer4;
    }

    /**
     * 获取来源ID
     *
     * @return ref_id - 来源ID
     */
    public Integer getRefId() {
        return refId;
    }

    /**
     * 设置来源ID
     *
     * @param refId 来源ID
     */
    public void setRefId(Integer refId) {
        this.refId = refId;
    }

    /**
     * 获取处理状态：0：未分配；1-已自动分配；2-已手动分配； 3-分配到td系统;4-特殊活动不派发
     *
     * @return sc_status - 处理状态：0：未分配；1-已自动分配；2-已手动分配； 3-分配到td系统;4-特殊活动不派发
     */
    public Byte getScStatus() {
        return scStatus;
    }

    /**
     * 设置处理状态：0：未分配；1-已自动分配；2-已手动分配； 3-分配到td系统;4-特殊活动不派发
     *
     * @param scStatus 处理状态：0：未分配；1-已自动分配；2-已手动分配； 3-分配到td系统;4-特殊活动不派发
     */
    public void setScStatus(Byte scStatus) {
        this.scStatus = scStatus;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return plugs_id
     */
    public Integer getPlugsId() {
        return plugsId;
    }

    /**
     * @param plugsId
     */
    public void setPlugsId(Integer plugsId) {
        this.plugsId = plugsId;
    }

    /**
     * @return pro_id
     */
    public Integer getProId() {
        return proId;
    }

    /**
     * @param proId
     */
    public void setProId(Integer proId) {
        this.proId = proId;
    }

    /**
     * 获取是否可以派发
     *
     * @return assignable - 是否可以派发
     */
    public Boolean getAssignable() {
        return assignable;
    }

    /**
     * 设置是否可以派发
     *
     * @param assignable 是否可以派发
     */
    public void setAssignable(Boolean assignable) {
        this.assignable = assignable;
    }

    /**
     * 获取资源来源
     *
     * @return sc_source - 资源来源
     */
    public String getScSource() {
        return scSource;
    }

    /**
     * 设置资源来源
     *
     * @param scSource 资源来源
     */
    public void setScSource(String scSource) {
        this.scSource = scSource;
    }

    /**
     * @return sc_platform
     */
    public String getScPlatform() {
        return scPlatform;
    }

    /**
     * @param scPlatform
     */
    public void setScPlatform(String scPlatform) {
        this.scPlatform = scPlatform;
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
     * 获取是否验证
     *
     * @return reply_status - 是否验证
     */
    public Byte getReplyStatus() {
        return replyStatus;
    }

    /**
     * 设置是否验证
     *
     * @param replyStatus 是否验证
     */
    public void setReplyStatus(Byte replyStatus) {
        this.replyStatus = replyStatus;
    }

    /**
     * 获取资源类型(复苏资源)0、默认类型 2、复苏资源类型 3、12114资源类型
     *
     * @return resources_Type - 资源类型(复苏资源)0、默认类型 2、复苏资源类型 3、12114资源类型
     */
    public Byte getResourcesType() {
        return resourcesType;
    }

    /**
     * 设置资源类型(复苏资源)0、默认类型 2、复苏资源类型 3、12114资源类型
     *
     * @param resourcesType 资源类型(复苏资源)0、默认类型 2、复苏资源类型 3、12114资源类型
     */
    public void setResourcesType(Byte resourcesType) {
        this.resourcesType = resourcesType;
    }

    /**
     * 获取客户唯一标示
     *
     * @return cus_unique_id - 客户唯一标示
     */
    public String getCusUniqueId() {
        return cusUniqueId;
    }

    /**
     * 设置客户唯一标示
     *
     * @param cusUniqueId 客户唯一标示
     */
    public void setCusUniqueId(String cusUniqueId) {
        this.cusUniqueId = cusUniqueId;
    }

    /**
     * 获取1、网聊资源2、网聊加入派工列表3、第三方资源
     *
     * @return netchat_res - 1、网聊资源2、网聊加入派工列表3、第三方资源
     */
    public Byte getNetchatRes() {
        return netchatRes;
    }

    /**
     * 设置1、网聊资源2、网聊加入派工列表3、第三方资源
     *
     * @param netchatRes 1、网聊资源2、网聊加入派工列表3、第三方资源
     */
    public void setNetchatRes(Byte netchatRes) {
        this.netchatRes = netchatRes;
    }

    /**
     * 获取加入者
     *
     * @return add_emp_id - 加入者
     */
    public Integer getAddEmpId() {
        return addEmpId;
    }

    /**
     * 设置加入者
     *
     * @param addEmpId 加入者
     */
    public void setAddEmpId(Integer addEmpId) {
        this.addEmpId = addEmpId;
    }

    /**
     * 获取是否新资源，0：否，1：是
     *
     * @return new_res - 是否新资源，0：否，1：是
     */
    public Boolean getNewRes() {
        return newRes;
    }

    /**
     * 设置是否新资源，0：否，1：是
     *
     * @param newRes 是否新资源，0：否，1：是
     */
    public void setNewRes(Boolean newRes) {
        this.newRes = newRes;
    }

    /**
     * 获取来源渠道ID
     *
     * @return ytx_ref_id - 来源渠道ID
     */
    public Integer getYtxRefId() {
        return ytxRefId;
    }

    /**
     * 设置来源渠道ID
     *
     * @param ytxRefId 来源渠道ID
     */
    public void setYtxRefId(Integer ytxRefId) {
        this.ytxRefId = ytxRefId;
    }

    /**
     * 获取推广计划ID
     *
     * @return ytx_ref_id2 - 推广计划ID
     */
    public Integer getYtxRefId2() {
        return ytxRefId2;
    }

    /**
     * 设置推广计划ID
     *
     * @param ytxRefId2 推广计划ID
     */
    public void setYtxRefId2(Integer ytxRefId2) {
        this.ytxRefId2 = ytxRefId2;
    }

    /**
     * 获取推广单元ID
     *
     * @return ytx_ref_id3 - 推广单元ID
     */
    public Integer getYtxRefId3() {
        return ytxRefId3;
    }

    /**
     * 设置推广单元ID
     *
     * @param ytxRefId3 推广单元ID
     */
    public void setYtxRefId3(Integer ytxRefId3) {
        this.ytxRefId3 = ytxRefId3;
    }

    /**
     * 获取推广关键词ID
     *
     * @return ytx_ref_id4 - 推广关键词ID
     */
    public Integer getYtxRefId4() {
        return ytxRefId4;
    }

    /**
     * 设置推广关键词ID
     *
     * @param ytxRefId4 推广关键词ID
     */
    public void setYtxRefId4(Integer ytxRefId4) {
        this.ytxRefId4 = ytxRefId4;
    }
}