package com.longbow.mybatis.mycat;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;

/**
 * Created by zhangbin on 2018/9/13.
 */
@Slf4j
@Component
@Intercepts({@Signature(type = StatementHandler.class,
        method = "prepare", args = {Connection.class, Integer.class})})
public class TenantInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        String tenant = TenantContextHolder.getTenant();
        log.info("TenantInterceptor is call! tenant = {}", tenant);

        if (tenant == null || tenant == "") {
            log.info("tenant 为空，不需要改写sql语句");
            return invocation.proceed();
        }

        if (invocation.getTarget() instanceof RoutingStatementHandler) {

            log.info("处理sql开始");
            RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation.getTarget();
            StatementHandler delegate = (StatementHandler) ReflectHelper.getFieldValue(statementHandler, "delegate");
            BoundSql boundSql = delegate.getBoundSql();
            Object obj = boundSql.getParameterObject();

            // 通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
            MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getFieldValue(delegate, "mappedStatement");

            // 拦截到的prepare方法参数是一个Connection对象
            Connection connection = (Connection) invocation.getArgs()[0];

            // 获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句
            String sql = boundSql.getSql();

            // 给当前的page参数对象设置总记录数
            log.info("处理之前: {}", sql);

            //对 sql 增加 mycat 注解
            sql = "/*!mycat:schema=" + tenant + " */" + sql;
            log.info("加入处理后: {}", sql);

            ReflectHelper.setFieldValue(boundSql, "sql", sql);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
