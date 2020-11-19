package com.exercise.security.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.exercise.common.core.entity.BaseEntity;
import com.exercise.common.core.validator.Create;
import com.exercise.common.core.validator.FieldRepeatValidator;
import com.exercise.common.core.validator.Update;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("sys_user")
@FieldRepeatValidator(field = "username", message = "账号重复，请重新输入账号！")
public class SysUser extends BaseEntity implements Serializable {

    @Override
    protected Serializable pkVal() {
        return super.pkVal();
    }

    @ApiModelProperty(value = "id")
    @TableId(value="id", type= IdType.AUTO)
    @NotNull(message = "用户id不能为空", groups={Update.class})
    private Long id;

    @ApiModelProperty(value = "用户名")
    @TableField("username")
    @NotBlank(message = "用户名不能为空", groups = {Create.class, Update.class})
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "姓名")
    private String fullname;

    @ApiModelProperty(value = "头像")
    private String headImgUrl;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "性别（0男，1女）")
    private Boolean sex;

    @ApiModelProperty(value = "是否启用（1启用，0停用）")
    private Boolean enabled;

    @ApiModelProperty(value = "用户分组id")
    private Long userTypeId;

    @ApiModelProperty(value = "用户分组")
    private String type;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;


    //================= 临时字段 start =================================
    @ApiModelProperty(value = "登陆返回token")
    private String token;

    @ApiModelProperty(value = "关联角色")
    private List<SysRole> roles;

    @ApiModelProperty(value = "用户所有权限")
    private List<SysMenu> menus;

    //================= 临时字段 end   ================================

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    @JsonProperty
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickName=").append(nickName);
        sb.append(", fullname=").append(fullname);
        sb.append(", headImgUrl=").append(headImgUrl);
        sb.append(", phone=").append(phone);
        sb.append(", sex=").append(sex);
        sb.append(", enabled=").append(enabled);
        sb.append(", userTypeId=").append(userTypeId);
        sb.append(", type=").append(type);
        sb.append(", token=").append(token);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}