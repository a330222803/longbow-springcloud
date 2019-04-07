package com.longbow.mybatis.mycat;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
@Order(value = -1)
public class TenantAspect {

    @Autowired
    private HttpServletRequest request;

    @Pointcut("execution( * com.longbow..repository..*.*(..))")
    public void daoAspect() {
    }

    @Before("daoAspect()")
    public void switchDataSource(JoinPoint point) {
        if(request == null){
            log.info("******* request is null");
            return;
        }
        String tenant = request.getHeader("Tenant-Code");
        log.info("******* tenant = {}", tenant);
        if(tenant != null) {
            TenantContextHolder.setTenant(tenant);
            log.info("Switch DataSource to [{}] in Method [{}]",
                    TenantContextHolder.getTenant(), point.getSignature());
        }
    }

    @After("daoAspect())")
    public void restoreDataSource(JoinPoint point) {
        TenantContextHolder.remove();
        log.info("Restore DataSource to [{}] in Method [{}]",
                TenantContextHolder.getTenant(), point.getSignature());
    }
}
