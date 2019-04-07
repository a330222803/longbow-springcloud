package com.longbow.gateway.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangbin on 2018/8/30.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.longbow.gateway.web"))
                .paths(PathSelectors.any()).build()
                .globalOperationParameters(setParameter());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CRM微服务系统")
                .description("CRM微服务系统接口文档说明")
                .termsOfServiceUrl("http://localhost:8080")
                .contact(new Contact("zhangbin", "", "330222803@qq.com"))
                .version("1.0")
                .build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(null, "list", "alpha", "schema",
                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
    }

    // 配置全局参数token
    private List<Parameter> setParameter() {
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder par = new ParameterBuilder();
        // token参数
        pars.add(par.name("Authorization").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build());
        return pars;
    }
}
