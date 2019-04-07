package com.longbow.api.customer.service;


import com.longbow.api.customer.CustomerAPI;
import com.longbow.api.customer.domain.CustomerInfo;
import com.longbow.core.IServiceLayer;
import com.longbow.core.exception.BizBaseException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 客户服务的接口
 *
 * @author zhangbin
 * @date 2018/7/26
 */
@FeignClient(value = CustomerAPI.APPID, path = "/" + CustomerAPI.BEAN_CUSTOMER_SERVICE)
public interface ICustomerService extends IServiceLayer {

    /**
     * 实时进线
     *
     * @param phoneNumber 参数
     * @throws BizBaseException 异常信息
     */
    @RequestMapping(method = RequestMethod.POST, value = CustomerAPI.CUSTOMER_GET_BY_PHONE)
    CustomerInfo getCustomerByPhone(String phoneNumber) throws BizBaseException;

}
