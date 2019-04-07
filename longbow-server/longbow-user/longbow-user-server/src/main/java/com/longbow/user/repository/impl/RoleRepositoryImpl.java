package com.longbow.user.repository.impl;

import com.longbow.user.dal.mapper.SysRoleMapper;
import com.longbow.user.dal.po.SysRole;
import com.longbow.user.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangbin on 2018/9/3.
 */
@Slf4j
@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public List<SysRole> selectByResId(Long resId) {
//        return roleMapper.selectByResId(resId);
        return null;
    }

    @Override
    public List<SysRole> selectByUserId(Long userId) {
//        return roleMapper.selectByUserId(userId);
        return null;
    }
}
