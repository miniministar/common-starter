package com.exercise.security.model;

import com.exercise.common.core.validator.Create;
import com.exercise.common.core.validator.Update;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
public class SysNotice implements Serializable {
    @ApiModelProperty(value = "公告ID")
    private Long id;

    @NotBlank(message = "标题不能为空", groups = {Create.class, Update.class})
    @ApiModelProperty(value = "公告标题")
    private String noticeTitle;

    @ApiModelProperty(value = "公告类型（1通知 2公告）")
    private Integer noticeType;

    @ApiModelProperty(value = "公告状态（0正常 1关闭）")
    private Integer status;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "标签，1一般，2紧急，3其他")
    private Integer tags;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间 既发布时间")
    private Date modifyTime;

    @ApiModelProperty(value = "公告内容")
    private String noticeContent;

    //================ 辅助查询字段 start==============================
    @ApiModelProperty(value = "辅助查询字段 - 发布时间")
    private String publishDay;

    //================ 辅助查询字段 end  ==============================

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getTags() {
        return tags;
    }

    public void setTags(Integer tags) {
        this.tags = tags;
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

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", noticeTitle=").append(noticeTitle);
        sb.append(", noticeType=").append(noticeType);
        sb.append(", status=").append(status);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", remark=").append(remark);
        sb.append(", tags=").append(tags);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", noticeContent=").append(noticeContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}