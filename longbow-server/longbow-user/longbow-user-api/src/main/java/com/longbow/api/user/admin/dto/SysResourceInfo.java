package com.longbow.api.user.admin.dto;

import com.longbow.core.domain.BaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "新增权限")
public class SysResourceInfo extends BaseInfo {

	@ApiModelProperty(hidden = true)
	private Long pid;

	@ApiModelProperty(value = "权限名")
	private String permissionName;

	@ApiModelProperty(value = "权限码")
	private String permissionCode;

	@ApiModelProperty(value = "父ID")
	private Long parentId;

	@ApiModelProperty(value = "父菜单名称")
	private String parentName;

	@ApiModelProperty(value = "层级")
	private Integer level;

	@ApiModelProperty(value = "菜单类型")
	private Integer ptype;

	@ApiModelProperty(value = "是否外部链接")
	private Integer isOuterLink;

	@ApiModelProperty(value = "URL")
	private String url;

	private String method;

	private Integer sequence;

	private Date createTime;

	private Date updateTime;

	@ApiModelProperty(hidden = true)
	private List<SysResourceInfo> datas;

	private Integer	regex;

	@ApiModelProperty(value = "ICON图标")
	private String	module;

}
