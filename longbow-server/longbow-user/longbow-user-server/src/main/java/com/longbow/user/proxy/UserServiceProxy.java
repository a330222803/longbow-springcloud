package com.longbow.user.proxy;

import com.longbow.api.user.UserAPI;
import com.longbow.api.user.dto.*;
import com.longbow.api.user.service.IUserService;
import com.longbow.core.IProxyLayer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zhangbin on 2018/7/26.
 */
@RestController
@RequestMapping("/" + UserAPI.BEAN_USER_SERVICE)
public class UserServiceProxy implements IUserService, IProxyLayer {

    @Resource(name = UserAPI.BEAN_USER_SERVICE)
    private IUserService userService;

    @Override
    public void certify(@RequestBody CertifyUserRequest user) {
        userService.certify(user);
    }

    @Override
    public void register(@RequestBody RegisterUserRequest user) {
        userService.register(user);
    }

    @Override
    public String login(@RequestBody LoginUserRequest user) {
        return userService.login(user);
    }

    @Override
    public void logout() {
        userService.logout();
    }

    @Override
    public String refresh() {
        return userService.refresh();
    }

    @Override
    public void changePassword(@RequestParam("oldPassword") String oldPassword,
                               @RequestParam("newPassword") String newPassword) {
        userService.changePassword(oldPassword,newPassword);
    }

    @Override
    public void resetPassword() {
        userService.resetPassword();
    }

    @Override
    public void edit(@RequestBody EditUserRequest user) {
        userService.edit(user);
    }

    @Override
    public ConflictUserResponse conflictUser(@RequestBody ConflictUserRequest user) {
        return userService.conflictUser(user);
    }

    @Override
    public GetUserInfoResponse getUserInfo() {
        return userService.getUserInfo();
    }
}
