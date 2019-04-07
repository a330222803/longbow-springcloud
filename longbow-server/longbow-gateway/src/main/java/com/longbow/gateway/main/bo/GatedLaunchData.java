package com.longbow.gateway.main.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangbin on 2018/8/31.
 */
@Getter
@Setter
public class GatedLaunchData implements Serializable {
    private String uuid;
    private String routeName;
    private String paramName;
    private String paramValue;
    private String bodyRegexp;
    private Map<String, String> gatedServerMetadata = new HashMap<>();
}
