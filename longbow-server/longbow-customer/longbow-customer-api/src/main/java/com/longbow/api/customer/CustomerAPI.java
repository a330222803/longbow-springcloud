package com.longbow.api.customer;

/**
 * Created by zhangbin on 2018/7/26.
 */
public interface CustomerAPI {
    public final static String APPID = "crm-customer-server";

    public final static String BEAN_CUSTOMER_SERVICE = "customerService";
    public final static String CUSTOMER_GET_BY_PHONE = "/getCusInfoByPhone";

    public final static String BEAN_STAFF_SERVICE = "staffService";
    public final static String STAFF_GET_LOGIN_STAFF = "/getLoginStaffInfo";
}
