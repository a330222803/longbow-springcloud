package com.longbow.customer;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangbin on 2018/9/5.
 */
@Slf4j
@Component
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

//        //灰度示例
//        RibbonFilterContextHolder.clearCurrentContext();
//        String flag = request.getHeader("release-tag");
//        log.info("release-tag = {}", flag);
//        if (flag != null && flag.trim().length()>0) {
////            String value = ServiceInfoUtil.getReleaseTag();
//            //获取目前系统的配置
//            String value = "";
//            RibbonFilterContextHolder.getCurrentContext().add("release-tag", value);
//        }
    }
}
