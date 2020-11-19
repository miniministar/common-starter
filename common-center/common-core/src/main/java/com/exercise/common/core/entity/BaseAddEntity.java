package com.exercise.common.core.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 *  <p> 创建日期 </p>
 */
@Getter
@Setter
public abstract class BaseAddEntity<T extends Model> extends Model {
    /**
     * 创建日期 - 现在时表示主动创建
     */
    @ApiModelProperty(value = "创建日期")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @Past(message = "创建时间必须是过去时间")
    private Date createTime;
    /**
     * 创建人
     */
//    @TableField(value = "creator_id", fill = FieldFill.INSERT)
//    private Long creatorId;
    /**
     * 是否可用
     */
//    @TableField(fill = FieldFill.INSERT)
//    private Boolean availableFlag;
}
