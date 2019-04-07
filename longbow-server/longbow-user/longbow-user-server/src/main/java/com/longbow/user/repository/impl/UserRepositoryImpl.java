package com.longbow.user.repository.impl;

import com.longbow.user.dal.mapper.SysSessionMapper;
import com.longbow.user.dal.mapper.SysUserMapper;
import com.longbow.user.dal.po.SysSession;
import com.longbow.user.dal.po.SysUser;
import com.longbow.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangbin on 2018/9/3.
 */
@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysSessionMapper sessionMapper;

    @Override
    public SysUser selectOneByCondition(SysUser user) {
//        Example obj = Example.builder(SysUser.class)
//                .where(Sqls.custom()
//                        .andEqualTo("username", username)
//                ).build();
//        userMapper.selectOneByExample(obj);
        return userMapper.selectOne(user);
    }

    @Override
    public void saveUserOne(SysUser user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void saveSession(SysSession session) {
        sessionMapper.insertSelective(session);
    }
}
