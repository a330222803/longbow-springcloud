package com.longbow.api.user.service;

import com.longbow.api.user.UserAPI;
import com.longbow.api.user.dto.*;
import com.longbow.core.IServiceLayer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 用户接口，前台用户自服务接口
 * @author zhangbin
 * @date 2018/7/26
 */
@FeignClient(value = UserAPI.APPID, path = "/" + UserAPI.BEAN_USER_SERVICE)
public interface IUserService extends IServiceLayer {

    /**
     * 注册新用户
     * @param user
     */
    @RequestMapping(method = RequestMethod.POST, value = UserAPI.USER_REGISTER)
    void register(@RequestBody RegisterUserRequest user);

    /**
     * 用户登录
     * @param user
     * @return token
     */
    @RequestMapping(method = RequestMethod.POST, value = UserAPI.USER_LOGIN)
    String login(@RequestBody LoginUserRequest user);

    /**
     * 用户登出
     */
    @RequestMapping(method = RequestMethod.POST, value = UserAPI.USER_LOGOUT)
    void logout();

    /**
     * 刷新用户token
     * @return token
     */
    @RequestMapping(method = RequestMethod.POST, value = UserAPI.USER_REFRESH)
    String refresh();

    /**
     * 用户修改密码
     * @param oldPassword
     * @param newPassword
     */
    @RequestMapping(method = RequestMethod.POST, value = UserAPI.USER_PASSWORD_CHANGE)
    void changePassword(@RequestParam("oldPassword") String oldPassword,
                        @RequestParam("newPassword") String newPassword);

    /**
     * 用户重置密码
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = UserAPI.USER_PASSWORD_RESET)
    void resetPassword();

    /**
     * 编辑用户信息
     * @param user
     */
    @RequestMapping(method = RequestMethod.POST, value = UserAPI.USER_EDIT)
    void edit(@RequestBody EditUserRequest user);

    /**
     * 用户实名制认证
     * @param user
     */
    @RequestMapping(method = RequestMethod.POST, value = UserAPI.USER_CERTIFY)
    void certify(@RequestBody CertifyUserRequest user);

    /**
     * 判断是否重复用户
     * @param user
     * @return true:重复,false:不重复
     */
    @RequestMapping(method = RequestMethod.POST, value = UserAPI.USER_CONFLICT)
    ConflictUserResponse conflictUser(@RequestBody ConflictUserRequest user);

    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = UserAPI.USER_INFO)
    GetUserInfoResponse getUserInfo();

}
