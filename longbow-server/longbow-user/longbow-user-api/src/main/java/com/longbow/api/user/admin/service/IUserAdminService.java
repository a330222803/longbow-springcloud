package com.longbow.api.user.admin.service;

import com.longbow.api.user.UserAPI;
import com.longbow.core.IServiceLayer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 用户接口，后台管理员服务接口
 * @author zhangbin
 * @date 2018/7/26
 */
@FeignClient(value = UserAPI.APPID, path = "/" + UserAPI.BEAN_USER_ADMIN_SERVICE)
public interface IUserAdminService extends IServiceLayer {

    /**
     * 管理员重置用户密码
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = UserAPI.USER_ADMIN_PASSWORD_RESET)
    void resetPassword(@RequestParam("userId") String userId);

}
