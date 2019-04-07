package com.longbow.security.core.annotations;

import com.longbow.security.suppot.LongbowSecurityServerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({LongbowSecurityServerAutoConfiguration.class})
public @interface EnableLongbowSecurityServer {
}
