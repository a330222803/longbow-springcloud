package com.longbow.security.core.config.security;

import com.longbow.security.core.core.*;
import com.longbow.security.core.jwt.JwtAuthenticationTokenFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${passport.need-auth:true}")
    private boolean needAuth;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    @Qualifier("easySpringSecurityMetadataSource")
    private LongbowSecurityMetadataSource securityMetadataSource;
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private LongbowAccessDecisionVoter customAccessDecisionVoter;

    /**
     * 权限管理器
     * @param authenticationManagerBuilder
     * @throws Exception
     */
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * 替换框架默认的表决器
     * @throws Exception
     */
    public void changeSome() throws Exception {
        HttpSecurity httpSecurity = getHttp();
        FilterSecurityInterceptor securityInterceptor = httpSecurity.getSharedObject(FilterSecurityInterceptor.class);

        securityInterceptor.setAccessDecisionManager(accessDecisionManager());

        securityMetadataSource.setDefaultMetadataSource(securityInterceptor.getSecurityMetadataSource());
        securityMetadataSource.init();
        securityInterceptor.setSecurityMetadataSource(securityMetadataSource);
    }

    @Bean
    public AuthenticatedVoter authenticatedVoter(){
        return new AuthenticatedVoter();
    }

    /**
     * 自定义的投票器
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Bean(name = "accessDecisionManager")
    public AccessDecisionManager accessDecisionManager() {
        log.info("AccessDecisionManager");
        List<AccessDecisionVoter<? extends Object>> decisionVoters = new ArrayList<>();
//        decisionVoters.add(new RoleVoter());
//        decisionVoters.add(authenticatedVoter());
        decisionVoters.add(webExpressionVoter());// 启用表达式投票器
        decisionVoters.add(customAccessDecisionVoter);

        AffirmativeBased accessDecisionManager = new AffirmativeBased(decisionVoters);

        return accessDecisionManager;
    }

    /**
     * 表达式控制器
     */
    @Bean(name = "expressionHandler")
    public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
        log.info("DefaultWebSecurityExpressionHandler");
        DefaultWebSecurityExpressionHandler webSecurityExpressionHandler = new LongbowWebSecurityExpressionHandler();
        return webSecurityExpressionHandler;
    }

    /**
     * 表达式投票器
     */
    @Bean(name = "expressionVoter")
    public WebExpressionVoter webExpressionVoter() {
        log.info("WebExpressionVoter");
        WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
        webExpressionVoter.setExpressionHandler(webSecurityExpressionHandler());
        return webExpressionVoter;
    }

    /**
     * 用户密码加密算法
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return DigestUtils.md5Hex((String) charSequence);
            }

            @Override
            public boolean matches(CharSequence charSequence, String encodedPassword) {
                return encodedPassword.equals(DigestUtils.md5Hex((String) charSequence));
            }
        };
    }

    /**
     * 基础权限配置
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // 关闭csrf
        httpSecurity.csrf().disable()
                // 错误返回
                .exceptionHandling().authenticationEntryPoint(new LongbowAuthenticationEntryPoint())
                .accessDeniedHandler(new LongbowAccessDeniedHandler()).and()
                // don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        字符wildcard　　　　   描述
//        　　 ?　　　　　　　 匹配一个字符
//        　　 *　　　　　　　 匹配0个及以上字符
//        　　**　　　　　　　 匹配0个及以上目录directories
        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                //允许GET方式获取静态资源
                .antMatchers(HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.png",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/v2/api-docs").permitAll()
                //规定公共接口的配置为/*/pub/**，即第二个path目录为pub的不做权限拦截
                .antMatchers("/*/pub/**").permitAll()
                //ADMIN角色可以访问任何资源
//                .antMatchers("/**").permitAll()//access("customAdmin")
                //登录用户可以登出
                .antMatchers("/session/logout").authenticated()
                .antMatchers("/menu/tree").authenticated()
                .antMatchers("/user/info").authenticated()
                .antMatchers("/**").access("customAdmin")
                //除以上配置外的访问拒绝
                .anyRequest().denyAll();

        // Custom JWT based security filter
        if(needAuth) {
            log.info("插入权限控制");
            httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        }else {
            log.info("不需要插入权限控制");
        }
//        httpSecurity.exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login.html"))
//                .and().logout().logoutUrl("/logout.html").logoutSuccessUrl("/login.html").permitAll()
//                .and().exceptionHandling().accessDeniedPage("/access_denied.html");

//        //session管理
//        //session失效后跳转
//        httpSecurity.sessionManagement().invalidSessionUrl("/login.html");
//        //只允许一个用户登录,如果同一个账户两次登录,那么第一个账户将被踢下线,跳转到登录页面
//        httpSecurity.sessionManagement().maximumSessions(1).expiredUrl("/login.html");

        // disable page caching
        httpSecurity.headers().cacheControl();

        //解决不允许显示在iframe的问题
        httpSecurity.headers().frameOptions().disable();
    }

}