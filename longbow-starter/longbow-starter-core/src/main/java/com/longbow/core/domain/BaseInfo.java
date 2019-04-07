package com.longbow.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.longbow.core.IDumpObject;
import com.longbow.core.constants.ConstantEnum;
import com.longbow.core.constants.InfoStatusEnum;
import com.longbow.core.constants.OperTypeEnum;
import com.longbow.core.util.LongbowUtils;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 领域对象的基本信息
 * 将被系统内的所有领域对象所继承
 * Created by zhangbin on 2016/2/6.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseInfo implements Serializable,
        Cloneable,
        Comparable<BaseInfo>,
        IDumpObject {

    /**
     * 数字签名，验证请求数据是否有效
     */
    protected String sign;

    /**
     * 数据主键
     */
    @JsonProperty("id")
    protected String id;

    /**
     * 兼容当前的架构，由于在类似dubbo的分布式体系中，存在了重试机制，导致了在一个节点伪错误（显示错误，实际成功）时
     * 同一条记录会被保存2遍的情况，我们决定主键由前端传过来的机制，这样由数据库来控制，同一条记录不会被保存2遍
     */
    protected String uid;

    /**
     * 业务主键
     */
    @JsonProperty("code")
    protected String code;

    /**
     * 名称
     */
    @JsonProperty("name")
    protected String name;

    /**
     * 状态
     */
    protected Integer status = InfoStatusEnum.ENABLE.getValue();

    /**
     * 描述或者备注信息
     */
    protected String remark;

    /**
     * 创建人
     */
    protected String creator;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 更新人
     */
    protected String updator;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 租户ID
     */
    protected String tenantId = "default";

    /**
     * 语言
     */
    protected String language;

    /**
     * 在集群环境下
     * 是在哪个节点保存的
     */
    protected String node;

    /**
     * 每张表，确保此值被写入
     * 行数，一般用来做排序的
     * 在存入缓存的时候，也可以用来做分页查询
     * 所以我们在保存对象的时候，一定要保证此值的正确性。
     */
    protected Long rowNum = 0L;

    /**
     * 版本，用来实现乐观锁
     */
    protected Integer version = 0;

    /**
     * 终端设备
     * 一般用来说明此次提交发生在什么类型的设备上
     * desktop: 1,
     * pad: 3,
     * mobile: 5
     */
    protected Integer equipment = 1;

    /**
     * 设备名称，用来标识是在什么设备上登录
     */
    protected String deviceName;

    /**
     * 页面点击对象，仅仅记录日志数据
     */
    protected String menuCode;

    /**
     * 操作类型：表示对此对象的操作行为
     */
    protected OperTypeEnum operType = OperTypeEnum.READ;

    /**
     * 数据状态，标识是新增，还是修改，还是删除
     * 在baseEntity里面设置的
     */
    protected Integer dataStatus = 0;

    /**
     * 扩展属性信息
     */
    @JsonProperty("properties")
    protected Map<String, Object> properties = new HashMap<>();

    /**
     * 状态的名称翻译，主要供页面的序列化使用
     *
     * @return
     */
    public String getStatusName() {
        //在子类中继承实现
        for (ConstantEnum e : InfoStatusEnum.values()) {
            if (Objects.equals(e.getValue(), status)) {
                return e.getText();
            }
        }
        return status + "";
    }

    public <T extends BaseInfo> T buildProperties(String key, Object value) {
        this.getProperties().put(key, value);
        return (T) this;
    }

    /**
     * 复制对象
     * 我们不用BeanUtil的方式实现，而是自己来实现
     * 一方面减少包的依赖，另外也是提高效率
     */
    @Override
    public BaseInfo clone() throws CloneNotSupportedException {
        return (BaseInfo) super.clone();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.id != null) {
            sb.append(this.getId());
        }
        if (this.code != null) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(this.getCode());
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        if (this.getId() == null) {
            return super.hashCode();
        }
        return this.getId().hashCode() * 37 +
                (this.getCode() == null ? 0 : this.getCode().hashCode() * 37);
    }

    @Override
    public void dump() {
        System.out.println(this.id + "--" + this.code + "--" + this.name + "--" + this.status);
    }

    @Override
    public int compareTo(BaseInfo o) {
        return 0;
    }

    @Override
    public Object diff(Object o) throws RuntimeException {
        return LongbowUtils.objectDiff(this, o, "lastTimes,updateTime,language,createTime");
    }

    public void addProperties(String key, Object val) {
        this.properties.put(key, val);
    }

    public Object pro(String key) {
        return this.properties.get(key);
    }
}
