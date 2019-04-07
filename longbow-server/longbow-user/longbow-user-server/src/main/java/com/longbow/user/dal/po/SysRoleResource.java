package com.longbow.user.dal.po;

import com.longbow.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_role_resource")
public class SysRoleResource extends BaseEntity {
    @Column(name = "rol_res_id")
    private Integer rolResId;

    /**
     * 角色id
     */
    @Column(name = "rol_id")
    private Integer rolId;

    /**
     * 权限资源id
     */
    @Column(name = "res_id")
    private Integer resId;

    @Column(name = "dt_update_time")
    private Date dtUpdateTime;

    /**
     * @return rol_res_id
     */
    public Integer getRolResId() {
        return rolResId;
    }

    /**
     * @param rolResId
     */
    public void setRolResId(Integer rolResId) {
        this.rolResId = rolResId;
    }

    /**
     * 获取角色id
     *
     * @return rol_id - 角色id
     */
    public Integer getRolId() {
        return rolId;
    }

    /**
     * 设置角色id
     *
     * @param rolId 角色id
     */
    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    /**
     * 获取权限资源id
     *
     * @return res_id - 权限资源id
     */
    public Integer getResId() {
        return resId;
    }

    /**
     * 设置权限资源id
     *
     * @param resId 权限资源id
     */
    public void setResId(Integer resId) {
        this.resId = resId;
    }

    /**
     * @return dt_update_time
     */
    public Date getDtUpdateTime() {
        return dtUpdateTime;
    }

    /**
     * @param dtUpdateTime
     */
    public void setDtUpdateTime(Date dtUpdateTime) {
        this.dtUpdateTime = dtUpdateTime;
    }
}