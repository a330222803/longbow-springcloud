package com.longbow.core;

import com.longbow.core.domain.BaseInfo;
import com.longbow.core.util.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * * 持久实体域：基类
 * 子类方法，继承了父类上的方法，同时也会继承方法上的注解
 * 我们不在这里使用注解创建公共字段是因为我希望每个表的ID,Name有其自己的column定义
 * Created by zhangbin on 2016/5/5.
 */
@Getter
@Setter
@Slf4j
@ToString
public class BaseEntity<T extends BaseInfo> implements IPersistObject, Serializable {

//    @Id
//    @Column(name = "Id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;

    /**
     * 建立实体和Info的映射关系
     *
     * @return Info对象
     */
    protected T createInfo() {
        //在后续，可以通过这个来做实体的权限控制
        //例如在配置文件中配置相应的实体等等
        log.warn(this.getClass().getName() + " has no my info.");
        return null;
    }

    public T buildInfo(T t) {
        BeanUtil.beanCopy(this, t);
        //应该在子类中被继承
        return t;
    }

    public T buildInfo(Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
        BeanUtil.beanCopy(this, t);
        //应该在子类中被继承
        return t;
    }

    public T buildInfo() {
        T t = createInfo();
        //应该在子类中被继承
        return buildInfo(t);
    }

    public <R extends BaseEntity> R createWithInfo(T r, String... ignorePro) {
        R o = (R) this;
        BeanUtil.beanCopy(r, o, ignorePro);
        return o;
    }

}
