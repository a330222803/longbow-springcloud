package com.longbow.api.user.admin.dto;

import com.longbow.core.domain.BaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description: 角色管理 <br/>
 * ClassName:SysRole <br/>
 * Date: 2018年5月21日 上午9:18:42 <br/>
 * 
 * @author jianjun.zhang <br/>
 * @version
 */
@Data
@ApiModel(value = "新增角色")
public class SysRoleInfo extends BaseInfo {
 	 
	@ApiModelProperty(hidden = true)
	private Long rolId;
	 
	@ApiModelProperty(value = "角色名称")
	private String rolName;
	 
	@ApiModelProperty(value = "角色描述 ")
	private String rolDesc;
}
