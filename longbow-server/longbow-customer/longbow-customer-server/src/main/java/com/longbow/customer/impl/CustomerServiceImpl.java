package com.longbow.customer.impl;

import com.longbow.api.customer.CustomerAPI;
import com.longbow.api.customer.domain.CustomerInfo;
import com.longbow.api.customer.service.ICustomerService;
import com.longbow.api.user.service.IUserService;
import com.longbow.core.IServiceLayer;
import com.longbow.core.exception.BizBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * Created by zhangbin on 2018/7/26.
 */
@Slf4j
@RefreshScope
@Service(CustomerAPI.BEAN_CUSTOMER_SERVICE)
public class CustomerServiceImpl implements ICustomerService, IServiceLayer {
    @Autowired
    private IUserService userService;
    @Value("${longbow.cust.test:aaa}")
    private String testAAA;

    @Override
    public CustomerInfo getCustomerByPhone(String phoneNumber) throws BizBaseException {
        CustomerInfo data = new CustomerInfo();
        data.setUsername("zbtest");
        log.info("*************{}",testAAA);
        userService.changePassword(data.getUsername(), "123456");
        data.setId("12344");
        return data;
    }
}
