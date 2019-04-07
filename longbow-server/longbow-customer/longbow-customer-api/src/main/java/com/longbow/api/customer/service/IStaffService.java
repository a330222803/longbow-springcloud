package com.longbow.api.customer.service;

import com.longbow.api.customer.CustomerAPI;
import com.longbow.api.customer.domain.StaffInfo;
import com.longbow.core.IServiceLayer;
import com.longbow.core.exception.BizBaseException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhangbin on 2018/9/21.
 */
@FeignClient(value = CustomerAPI.APPID, path = "/" + CustomerAPI.BEAN_STAFF_SERVICE)
public interface IStaffService extends IServiceLayer {
    /**
     * 获取当前登录的员工信息
     * @return
     * @throws BizBaseException
     */
    @RequestMapping(method = RequestMethod.GET, value = CustomerAPI.STAFF_GET_LOGIN_STAFF)
    StaffInfo getLoginStaffInfo() throws BizBaseException;
}
