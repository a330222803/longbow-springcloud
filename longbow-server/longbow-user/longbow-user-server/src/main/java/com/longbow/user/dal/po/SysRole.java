package com.longbow.user.dal.po;

import com.longbow.core.BaseEntity;
import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole extends BaseEntity {
    @Id
    private Integer id;

    private String code;

    private String name;

    private String remarks;

    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * DEPT-部门
ROLE-角色
POSITION-职位
     */
    @Column(name = "role_type")
    private String roleType;

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
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取DEPT-部门
ROLE-角色
POSITION-职位
     *
     * @return role_type - DEPT-部门
ROLE-角色
POSITION-职位
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * 设置DEPT-部门
ROLE-角色
POSITION-职位
     *
     * @param roleType DEPT-部门
ROLE-角色
POSITION-职位
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}