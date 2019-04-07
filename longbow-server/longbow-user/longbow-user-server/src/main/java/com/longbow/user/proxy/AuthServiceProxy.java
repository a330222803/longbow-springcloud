package com.longbow.user.proxy;

import com.longbow.core.IProxyLayer;
import com.longbow.core.exception.BizBaseException;
import com.longbow.api.user.UserAPI;
import com.longbow.api.user.admin.dto.SysResourceInfo;
import com.longbow.api.user.admin.dto.SysRoleResource;
import com.longbow.api.user.admin.service.IAuthService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhangbin on 2018/7/26.
 */
@RestController
@RequestMapping("/" + UserAPI.BEAN_AUTH_SERVICE)
public class AuthServiceProxy implements IAuthService, IProxyLayer {

    @Resource(name = UserAPI.BEAN_AUTH_SERVICE)
    private IAuthService authService;

    @Override
    public void addResource(@RequestBody SysResourceInfo sysResourceInfo) {
        authService.addResource(sysResourceInfo);
    }

    @Override
    public void editResource(@RequestBody SysResourceInfo sysResourceInfo) {
        authService.editResource(sysResourceInfo);
    }

    @Override
    public void delResource(Long pid) throws BizBaseException {
        authService.delResource(pid);
    }

    @Override
    public List<SysResourceInfo> listResource(Long parentId) {
        return authService.listResource(parentId);
    }

    @Override
    public void addRole(@RequestBody SysRoleResource rolePermission) {
        authService.addRole(rolePermission);
    }

    @Override
    public void editRoleResource(@RequestBody SysRoleResource rolePermission) {
        authService.editRoleResource(rolePermission);
    }

    @Override
    public void delRoleResource(Long roleId) {
        authService.delRoleResource(roleId);
    }

    @Override
    public HashMap<String, Collection<String>> listSystemAuthority() {
        return authService.listSystemAuthority();
    }
}
