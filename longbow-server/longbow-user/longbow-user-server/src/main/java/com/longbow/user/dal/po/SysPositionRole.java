package com.longbow.user.dal.po;

import com.longbow.core.BaseEntity;
import javax.persistence.*;

@Table(name = "sys_position_role")
public class SysPositionRole extends BaseEntity {
    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "role_id")
    private Integer roleId;

    /**
     * @return position_id
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * @param positionId
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
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