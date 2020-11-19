package com.exercise.security.model;

import com.exercise.common.core.annotation.Excel;
import com.exercise.common.core.annotation.Excel.ColumnType;
import com.exercise.common.core.annotation.Excel.Type;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysLoginLog implements Serializable {

    @Excel(name = "日志序号", cellType = ColumnType.NUMERIC, prompt = "日志编号")
    @ApiModelProperty(value = "ID")
    private Long id;

    @Excel(name = "操作人员账号")
    @ApiModelProperty(value = "用户账号")
    private String username;

    @Excel(name = "操作人员姓名")
    @ApiModelProperty(value = "用户")
    private String userRealName;

    @Excel(name = "IP地址")
    @ApiModelProperty(value = "登录IP地址")
    private String ipAddr;

    @Excel(name = "登录地点")
    @ApiModelProperty(value = "登录地点")
    private String loginLocation;

    @Excel(name = "浏览器类型")
    @ApiModelProperty(value = "浏览器类型")
    private String browser;

    @Excel(name = "操作系统")
    @ApiModelProperty(value = "操作系统")
    private String os;

    @Excel(name = "登录状态", readConverterExp = "0=成功,1=失败")
    @ApiModelProperty(value = "登录状态（0成功 1失败）")
    private Integer status;

    @ApiModelProperty(value = "提示消息")
    private String msg;

    @Excel(name = "操作时间", dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    @ApiModelProperty(value = "访问时间")
    private Date loginTime;


    //=============== 关联查询字段 start =============================

    @ApiModelProperty(value = "关联查询 - 开始日期")
    private String startDay;
    @ApiModelProperty(value = "关联查询 - 结束日期")
    private String endDay;

    //=============== 关联查询字段 end  =============================


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

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getLoginLocation() {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
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
        sb.append(", ipAddr=").append(ipAddr);
        sb.append(", loginLocation=").append(loginLocation);
        sb.append(", browser=").append(browser);
        sb.append(", os=").append(os);
        sb.append(", status=").append(status);
        sb.append(", msg=").append(msg);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}