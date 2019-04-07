package com.longbow.user.dal.po;

import com.longbow.core.BaseEntity;
import javax.persistence.*;

@Table(name = "sys_dept_role")
public class SysDeptRole extends BaseEntity {
    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "role_id")
    private Integer roleId;

    /**
     * @return dept_id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * @param deptId
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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