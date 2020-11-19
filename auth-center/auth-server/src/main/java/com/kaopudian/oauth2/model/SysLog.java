package com.exercise.oauth2.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class SysLog implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "用户账号")
    private String username;

    @ApiModelProperty(value = "用户")
    private String userRealName;

    @ApiModelProperty(value = "ip地址")
    private String ip;

    @ApiModelProperty(value = "模块名")
    private String module;

    @ApiModelProperty(value = "访问地址")
    private String url;

    @ApiModelProperty(value = "方式")
    private String method;

    @ApiModelProperty(value = "操作类型")
    private String type;

    @ApiModelProperty(value = "操作对象")
    private String operateObj;

    @ApiModelProperty(value = "状态(1.成功，2.失败)")
    private Integer flag;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "截止时间")
    private Date endTime;

    @ApiModelProperty(value = "耗时(毫秒)")
    private Long spentTime;

    @ApiModelProperty(value = "方法参数")
    private String params;

    @ApiModelProperty(value = "备注")
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperateObj() {
        return operateObj;
    }

    public void setOperateObj(String operateObj) {
        this.operateObj = operateObj;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(Long spentTime) {
        this.spentTime = spentTime;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", userRealName=").append(userRealName);
        sb.append(", ip=").append(ip);
        sb.append(", module=").append(module);
        sb.append(", url=").append(url);
        sb.append(", method=").append(method);
        sb.append(", type=").append(type);
        sb.append(", operateObj=").append(operateObj);
        sb.append(", flag=").append(flag);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", spentTime=").append(spentTime);
        sb.append(", params=").append(params);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}