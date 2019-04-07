package com.longbow.user.dal.po;

import com.longbow.core.BaseEntity;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_resource")
public class SysResource extends BaseEntity {
    @Id
    private Integer id;

    private String code;

    private String name;

    private String uri;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "system_id")
    private String systemId;

    private String remarks;

    private String sortid;

    private String images;

    /**
     * MENU
ELEMENT
DATA
OPTION
API
     */
    @Column(name = "res_type")
    private String resType;

    /**
     * 0-失效，1-有效
     */
    private String status;

    /**
     * 创建时间
     */
    @Column(name = "gmt8_create")
    private Date gmt8Create;

    /**
     * 修改时间
     */
    @Column(name = "gmt8_modify")
    private Date gmt8Modify;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String modifier;

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
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
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
     * @return uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * @return parent_id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return system_id
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * @param systemId
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    /**
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return sortid
     */
    public String getSortid() {
        return sortid;
    }

    /**
     * @param sortid
     */
    public void setSortid(String sortid) {
        this.sortid = sortid;
    }

    /**
     * @return images
     */
    public String getImages() {
        return images;
    }

    /**
     * @param images
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * 获取MENU
ELEMENT
DATA
OPTION
API
     *
     * @return res_type - MENU
ELEMENT
DATA
OPTION
API
     */
    public String getResType() {
        return resType;
    }

    /**
     * 设置MENU
ELEMENT
DATA
OPTION
API
     *
     * @param resType MENU
ELEMENT
DATA
OPTION
API
     */
    public void setResType(String resType) {
        this.resType = resType;
    }

    /**
     * 获取0-失效，1-有效
     *
     * @return status - 0-失效，1-有效
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置0-失效，1-有效
     *
     * @param status 0-失效，1-有效
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return gmt8_create - 创建时间
     */
    public Date getGmt8Create() {
        return gmt8Create;
    }

    /**
     * 设置创建时间
     *
     * @param gmt8Create 创建时间
     */
    public void setGmt8Create(Date gmt8Create) {
        this.gmt8Create = gmt8Create;
    }

    /**
     * 获取修改时间
     *
     * @return gmt8_modify - 修改时间
     */
    public Date getGmt8Modify() {
        return gmt8Modify;
    }

    /**
     * 设置修改时间
     *
     * @param gmt8Modify 修改时间
     */
    public void setGmt8Modify(Date gmt8Modify) {
        this.gmt8Modify = gmt8Modify;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
}