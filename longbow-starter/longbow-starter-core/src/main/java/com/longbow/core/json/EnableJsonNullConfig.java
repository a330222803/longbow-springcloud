package com.longbow.core.json;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by zhangbin on 2018/9/27.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(JsonNullConfiguration.class)
@Documented
public @interface EnableJsonNullConfig {
}
