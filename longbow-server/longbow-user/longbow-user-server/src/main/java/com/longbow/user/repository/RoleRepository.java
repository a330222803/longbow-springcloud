package com.longbow.user.repository;

import com.longbow.user.dal.po.SysRole;

import java.util.List;

/**
 * Created by zhangbin on 2018/9/3.
 */
public interface RoleRepository {
    List<SysRole> selectByResId(Long resId);
    List<SysRole> selectByUserId(Long userId);
}
