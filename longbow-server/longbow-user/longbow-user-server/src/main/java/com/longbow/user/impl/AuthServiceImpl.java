package com.longbow.user.impl;

import com.longbow.api.user.UserAPI;
import com.longbow.api.user.admin.dto.SysResourceInfo;
import com.longbow.api.user.admin.dto.SysRoleResource;
import com.longbow.api.user.admin.service.IAuthService;
import com.longbow.core.IServiceLayer;
import com.longbow.core.exception.BizBaseException;
import com.longbow.user.dal.po.SysResource;
import com.longbow.user.repository.ResourceRepository;
import com.longbow.user.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhangbin on 2018/9/19.
 */
@Slf4j
@Service(UserAPI.BEAN_AUTH_SERVICE)
public class AuthServiceImpl implements IAuthService, IServiceLayer {
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void addResource(@RequestBody SysResourceInfo sysResourceInfo) {
    }

    @Override
    public void editResource(@RequestBody SysResourceInfo sysResourceInfo) {

    }

    @Override
    public void delResource(Long pid) throws BizBaseException {

    }

    @Override
    public List<SysResourceInfo> listResource(Long parentId) {
        return null;
    }

    @Override
    public void addRole(@RequestBody SysRoleResource rolePermission) {
    }

    @Override
    public void editRoleResource(@RequestBody SysRoleResource rolePermission) {
    }

    @Override
    public void delRoleResource(Long roleId) {
    }

    @Override
    public HashMap<String, Collection<String>> listSystemAuthority() {
        HashMap<String, Collection<String>> map = new HashMap<>();

        List<SysResource> sysResourceList = resourceRepository.selectAllAndRole();
        for (SysResource res : sysResourceList) {
            String url = res.getUri();
            if(null == url || url.trim().isEmpty()){
                continue;
            }

//            List<SysRole> sysRoleList = res.getRoles();
//            for (SysRole role : sysRoleList) {
//                if (map.containsKey(url.trim())) {
//                    Collection<String> value = map.get(url.trim());
//                    value.add(role.getRolName());
//                    map.put(url.trim(), value);
//                } else {
//                    Collection<String> atts = new HashSet<>();
//                    atts.add(role.getRolName());
//                    map.put(url.trim(), atts);
//                }
//            }
        }

        return map;
    }
}
