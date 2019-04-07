package com.longbow.gateway.filter.pre;

import com.longbow.gateway.main.GatedLaunchHelper;
import com.longbow.gateway.main.bo.GatedLaunchData;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by zhangbin on 2018/6/17.
 */
@Slf4j
@Component
public class GatedLaunchFilter extends ZuulFilter {
    @Autowired
    private GatedLaunchHelper helper;

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 2;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //灰度示例
        RibbonFilterContextHolder.clearCurrentContext();

        final String serviceId = (String) ctx.get("proxy");
        log.info("serviceId = {}", serviceId);
        boolean flag = true;
        for (GatedLaunchData data : helper.getList()) {
            if(data.getRouteName().equals(serviceId)) {
                String value = request.getParameter(data.getParamName());

                if (value.equals(data.getParamValue())) {
                    Map<String, String> metadatas = data.getGatedServerMetadata();
                    for (Map.Entry<String, String> entry : metadatas.entrySet()) {
                        RibbonFilterContextHolder.getCurrentContext().add(entry.getKey(), entry.getValue());
                        ctx.addZuulRequestHeader(entry.getKey(), entry.getValue());
                    }
                    flag = false;
                }

            }
        }
        /**
         * 默认走测试环境
         */
//        if (flag) {
//            RibbonFilterContextHolder.getCurrentContext().add("release-tag", "test");
//            ctx.addZuulRequestHeader("release-tag", "test");
//        }

        return null;
    }
}
