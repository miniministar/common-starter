package com.exercise.security.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel(description = "用户管理-用户修改密码参数")
public class UserPasswordPara{

    @ApiModelProperty(value = "账号")
    @NotEmpty(message = "账号不能为空")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @NotEmpty(message = "旧密码不能为空")
    @ApiModelProperty(value = "旧密码")
    private String oldPassword;

}
