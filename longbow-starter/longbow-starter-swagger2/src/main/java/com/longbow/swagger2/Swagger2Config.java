package com.longbow.swagger2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
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
public class Swagger2Config {
    /**
     * 描述 : 系统版本
     */
    @Value("${info.build.version:1.0}")
    private String version;

    /**
     * 描述 : 系统名称
     */
    @Value("${info.build.name:User Center}")
    private String projectName;

    /**
     * 描述 : 作者
     */
    @Value("${info.author.name:zhangbin}")
    private String author;

    /**
     * 描述 : 作者邮箱
     */
    @Value("${info.author.email:330222803@qq.com}")
    private String authorEmail;

    /**
     * 描述 : addResourceHandlers
     *
     * @return WebMvcConfigurerAdapter
     */
//    @Bean
//    public WebMvcConfigurerAdapter addResourceHandlers() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("swagger-ui.html")
//                        .addResourceLocations("classpath:/META-INF/resources/");
//                registry.addResourceHandler("/webjars/**")
//                        .addResourceLocations("classpath:/META-INF/resources/webjars/");
//            }
//        };
//    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(setParameter());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(projectName+" online api document")
                .description(projectName+"在线接口文档说明")
                .contact(new Contact(author, "", authorEmail))
                .version(version)
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
