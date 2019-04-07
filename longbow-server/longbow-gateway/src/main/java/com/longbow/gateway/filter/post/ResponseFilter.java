package com.longbow.gateway.filter.post;

import com.alibaba.fastjson.JSON;
import com.longbow.core.BaseResponse;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by zhangbin on 2018/9/20.
 */
@Slf4j
@Component
public class ResponseFilter extends ZuulFilter {
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 3;
    }

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        if (ctx.getResponseStatusCode() != HttpStatus.OK.value()) {
            return false;
        }
        if (ctx.getRequest().getRequestURI().contains("v2/api-docs")) {
            return false;
        }
        final String serviceId = (String) ctx.get("proxy");
        log.info("serviceId = {}", serviceId);
        if (serviceId.equals("oldserver")) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();

        try {
            // 获取返回值内容，加以处理
            InputStream stream = context.getResponseDataStream();
            String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
            log.info("返回值：{}", body);
            String returnStr = "";

            //你的处理逻辑，加密，添加新的返回值等等.....
            Object object = JSON.parse(body);
            BaseResponse<Object> response = new BaseResponse<>();
            response.setMsg("ok");
            response.setCode(0);
            response.setData(object);
            returnStr = JSON.toJSONString(response);

            // 内容重新写入
            context.setResponseBody(returnStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
