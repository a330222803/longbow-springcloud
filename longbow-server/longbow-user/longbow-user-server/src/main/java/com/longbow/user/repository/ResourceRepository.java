package com.longbow.user.repository;

import com.longbow.user.dal.po.SysResource;

import java.util.List;

/**
 * Created by zhangbin on 2018/9/3.
 */
public interface ResourceRepository {
    List<SysResource> selectAll();
    List<SysResource> selectAllAndRole();
}
