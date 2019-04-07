package com.longbow.security.core.core;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by zhangbin on 2017/10/24.
 */
@Slf4j
@Component
public class LongbowAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException ex) throws IOException, ServletException {
        log.error("MyAccessDeniedHandler is called: " + ex.toString());

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        ErrorResponse resp = new ErrorResponse();
        resp.setCode(4);
        resp.setMsg("权限不足");
        resp.setData(ex.getMessage());
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(JSON.toJSONString(resp)));
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
