package com.longbow.gateway.web;

import com.longbow.core.BaseResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangbin on 2018/9/27.
 */
@RestController
public class ErrorHandlerController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @ApiIgnore
    @RequestMapping("/error")
    public BaseResponse<String> error(HttpServletRequest request, HttpServletResponse response) {
        Integer status = (Integer)request.getAttribute("javax.servlet.error.status_code");
        BaseResponse<String> resp = new BaseResponse<>();
        resp.setCode(1);
        resp.setData(status == 404 ? "访问地址不存在" : "内部服务器错误,正在处理");
        resp.setMsg(status == 404 ? "访问地址不存在" : "内部服务器错误,正在处理");
        return resp;
    }

}
