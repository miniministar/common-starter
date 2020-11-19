package com.exercise.security.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sys_role")
@FieldRepeatValidator(field = "code", message = "角色编码重复，请重新输入！")
public class SysRole extends BaseEntity implements Serializable {

    @Override
    protected Serializable pkVal() {
        return super.pkVal();
    }

    @TableId(value="id", type= IdType.AUTO)
    @NotNull(message = "id不能为空", groups={Update.class})
    @ApiModelProperty(value = "id")
    private Long id;

    @TableField("code")
    @NotBlank(message = "角色编码不能为空", groups = {Create.class, Update.class})
    @ApiModelProperty(value = "角色编码")
    private String code;

    @ApiModelProperty(value = "角色名")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    //================= 临时字段 start =================================

    @ApiModelProperty(value = "关联权限")
    private List<SysMenu> menus;

    //================= 临时字段 end   ================================

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}