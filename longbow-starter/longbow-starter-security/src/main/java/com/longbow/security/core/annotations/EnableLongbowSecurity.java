package com.longbow.security.core.annotations;

import com.longbow.security.suppot.LongbowSecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({LongbowSecurityAutoConfiguration.class})
public @interface EnableLongbowSecurity {
}
