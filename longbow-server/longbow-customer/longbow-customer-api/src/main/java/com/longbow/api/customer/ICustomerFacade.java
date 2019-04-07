package com.longbow.api.customer;

import com.longbow.core.BaseResponse;
import com.longbow.core.IFacadeLayer;

/**
 * 客户服务对外暴露的接口
 *
 * @author zhangbin
 * @date 2018/7/26
 */
public interface ICustomerFacade extends IFacadeLayer {

    /**
     * 实时进线
     *
     * @param phone
     * @return
     */
    BaseResponse getCustomerByPhone(String phone);

}
