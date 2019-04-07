package com.longbow.api.user.admin.dto;

import com.longbow.core.domain.BaseInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Description: <br/>
 * ClassName:SysRoleResource <br/>
 * Date: 2018年5月21日 下午2:47:14 <br/>
 * 
 * @author jianjun.zhang <br/>
 * @version
 */
@Data
public class SysRoleResource extends BaseInfo {
    
	@ApiModelProperty(value = "角色ID")
	private Long rolId;

	@ApiModelProperty(value = "角色名称")
	private String rolName;
	 
	@ApiModelProperty(value = "角色描述 ")
	private String rolDesc;
 
	@ApiModelProperty(value = "权限ID")
	private List<Long> pids;
}
