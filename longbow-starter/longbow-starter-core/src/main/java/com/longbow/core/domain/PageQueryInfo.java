package com.longbow.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * Created by zhangbin on 2018/11/14.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PageQueryInfo extends BaseInfo {
    private Integer pageNum = 1;
    private Integer pageSize = 20;
    private String orderName;
    private String orderDesc;
    /**
     * 设置默认排序方式
     */
    public void setDefaultOrder(String orderName, String orderDesc) {
        if (StringUtils.isEmpty(this.orderName) || StringUtils.isEmpty(this.orderDesc)) {
            setOrderName(orderName);
            setOrderDesc(orderDesc);
        }
    }
}
