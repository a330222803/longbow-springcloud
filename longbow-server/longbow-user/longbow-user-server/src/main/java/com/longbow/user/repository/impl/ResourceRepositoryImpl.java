package com.longbow.user.repository.impl;

import com.longbow.user.dal.mapper.SysResourceMapper;
import com.longbow.user.dal.po.SysResource;
import com.longbow.user.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangbin on 2018/9/19.
 */
@Repository
public class ResourceRepositoryImpl implements ResourceRepository {
    @Autowired
    private SysResourceMapper resourceMapper;

    @Override
    public List<SysResource> selectAll() {
        return resourceMapper.selectAll();
    }

    @Override
    public List<SysResource> selectAllAndRole() {
//        return resourceMapper.selectAllAndRole();
        return null;
    }
}
