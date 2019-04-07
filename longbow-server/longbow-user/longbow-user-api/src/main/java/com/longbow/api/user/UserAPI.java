package com.longbow.api.user;

/**
 * Created by zhangbin on 2018/7/26.
 */
public interface UserAPI {
    /**
     * 微服务标识
     */
    public final static String APPID = "longbow-user-server";

    /**
     * 服务bean实体标识
     */
    public final static String BEAN_USER_SERVICE = "userService";
    public final static String BEAN_AUTH_SERVICE = "authService";
    public final static String BEAN_USER_ADMIN_SERVICE = "userAdminService";

    /**
     * 用户相关操作
     */
    public final static String USER_REGISTER = "/user/register"; // 注册
    public final static String USER_LOGIN = "/user/login"; // 登录
    public final static String USER_LOGOUT = "/user/logout"; // 登出
    public final static String USER_REFRESH = "/user/refresh"; // 刷新
    public final static String USER_PASSWORD_CHANGE = "/user/changePassword"; // 修改密码
    public final static String USER_PASSWORD_RESET = "/user/resetPassword"; // 重置密码
    public final static String USER_EDIT = "/user/edit"; // 编辑信息
    public final static String USER_CERTIFY = "/user/certify"; // 实名制认证
    public final static String USER_CONFLICT = "/user/conflict"; // 判断是否重复用户
    public final static String USER_INFO = "/user"; // 获取用户信息

    /**
     * 用户权限相关操作
     */
    public final static String USER_GET_BY_USERNAME = "/getUserByUsername";
    public final static String AUTH_LIST = "/auth/list";
    public final static String AUTH_RES_ADD = "/sysPermission/save";
    public final static String AUTH_RES_LIST = "/sysPermission/listSysPermission";
    public final static String AUTH_RES_EDIT = "/sysPermission/permissionUpdate";
    public final static String AUTH_RES_DEL = "/sysPermission/permissionDelete";
    public final static String AUTH_ROLE_LIST = "/sysPermission/roleList";
    public final static String AUTH_ROLE_RES_LIST = "/sysPermission/listRolePermission";
    public final static String AUTH_ROLE_RES_SAVE = "/sysPermission/saveRolePermission";
    public final static String AUTH_ROLE_RES_EDIT = "/sysPermission/updateRolePermission";
    public final static String AUTH_ROLE_RES_DEL = "/sysPermission/deleteRolePermission";

    /**
     * 管理员用户相关操作
     */
    public final static String USER_ADMIN_PASSWORD_RESET = "/admin/user/resetPassword"; // 重置密码

}
