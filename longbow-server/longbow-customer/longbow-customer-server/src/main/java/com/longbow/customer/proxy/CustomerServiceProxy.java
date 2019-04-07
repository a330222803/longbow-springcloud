package com.longbow.customer.proxy;

import com.longbow.api.customer.CustomerAPI;
import com.longbow.api.customer.domain.CustomerInfo;
import com.longbow.api.customer.service.ICustomerService;
import com.longbow.core.IProxyLayer;
import com.longbow.core.exception.BizBaseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zhangbin on 2018/7/26.
 */
@RestController
@RequestMapping("/" + CustomerAPI.BEAN_CUSTOMER_SERVICE)
public class CustomerServiceProxy implements ICustomerService, IProxyLayer {

    @Resource(name = CustomerAPI.BEAN_CUSTOMER_SERVICE)
    private ICustomerService customerService;

    @Override
    public CustomerInfo getCustomerByPhone(String phoneNumber) throws BizBaseException {
        return customerService.getCustomerByPhone(phoneNumber);
    }

}
