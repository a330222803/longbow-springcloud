package com.longbow.security.core.core;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Slf4j
@Component
public class LongbowAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
//        log.info("MyAuthenticationEntryPoint commence is called.");
////        response.setHeader("Authorization","sfsdfsfsdfsfs");
////        response.sendRedirect("/login.html");
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");

        //返回json形式的错误信息
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ErrorResponse resp = new ErrorResponse();
        resp.setCode(4);
        resp.setMsg("用户未登录");
        resp.setData(authException.getLocalizedMessage());
        response.getWriter().println(JSON.toJSONString(resp));
        response.getWriter().flush();
    }

    @Setter
    @Getter
    @NoArgsConstructor
    private static class ErrorResponse implements Serializable {
        private Integer code;
        private String msg;
        private String data;
    }
}