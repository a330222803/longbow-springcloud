package com.longbow.user.dal.po;

import com.longbow.core.BaseEntity;
import javax.persistence.*;

@Table(name = "sys_role_res")
public class SysRoleRes extends BaseEntity {
    @Column(name = "res_id")
    private Integer resId;

    @Column(name = "role_id")
    private Integer roleId;

    /**
     * @return res_id
     */
    public Integer getResId() {
        return resId;
    }

    /**
     * @param resId
     */
    public void setResId(Integer resId) {
        this.resId = resId;
    }

    /**
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}