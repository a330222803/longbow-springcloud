package com.longbow.api.user.admin.service;

import com.longbow.api.user.UserAPI;
import com.longbow.api.user.admin.dto.SysResourceInfo;
import com.longbow.api.user.admin.dto.SysRoleResource;
import com.longbow.core.IServiceLayer;
import com.longbow.core.exception.BizBaseException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;


/**
 * 权限管理的接口
 * @author zhangbin
 * @date 2018/7/26
 */
@FeignClient(value = UserAPI.APPID, path = "/" + UserAPI.BEAN_AUTH_SERVICE)
public interface IAuthService extends IServiceLayer {

    @RequestMapping(method = RequestMethod.POST, value = UserAPI.AUTH_RES_ADD)
    void addResource(@RequestBody SysResourceInfo sysResourceInfo);

    @RequestMapping(method = RequestMethod.POST, value = UserAPI.AUTH_RES_EDIT)
    void editResource(@RequestBody SysResourceInfo sysResourceInfo);

    @RequestMapping(method = RequestMethod.POST, value = UserAPI.AUTH_RES_DEL)
    void delResource(Long pid) throws BizBaseException;

    @RequestMapping(method = RequestMethod.GET, value = UserAPI.AUTH_RES_LIST)
    List<SysResourceInfo> listResource(Long parentId);

    @RequestMapping(method = RequestMethod.POST, value = UserAPI.AUTH_ROLE_RES_SAVE)
    void addRole(@RequestBody SysRoleResource rolePermission);

    @RequestMapping(method = RequestMethod.POST, value = UserAPI.AUTH_ROLE_RES_EDIT)
    void editRoleResource(@RequestBody SysRoleResource rolePermission);

    @RequestMapping(method = RequestMethod.POST, value = UserAPI.AUTH_ROLE_RES_DEL)
    void delRoleResource(Long roleId);

    @RequestMapping(method = RequestMethod.GET, value = UserAPI.AUTH_LIST)
    HashMap<String, Collection<String>> listSystemAuthority();

}
