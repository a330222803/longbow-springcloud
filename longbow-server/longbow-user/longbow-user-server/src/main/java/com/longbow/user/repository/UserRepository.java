package com.longbow.user.repository;

import com.longbow.user.dal.po.SysSession;
import com.longbow.user.dal.po.SysUser;

/**
 * Created by zhangbin on 2018/9/3.
 */
public interface UserRepository {
    SysUser selectOneByCondition(SysUser user);
    void saveUserOne(SysUser user);
    void saveSession(SysSession session);
}
